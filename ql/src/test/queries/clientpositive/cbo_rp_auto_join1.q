set hive.cbo.returnpath.hiveop=true;
set hive.stats.fetch.column.stats=true;
set hive.optimize.semijoin.conversion=true;
;

set hive.exec.reducers.max = 1;
set hive.transpose.aggr.join=true;
-- SORT_QUERY_RESULTS

CREATE TABLE tbl1_n13(key int, value string) CLUSTERED BY (key) SORTED BY (key) INTO 2 BUCKETS;
CREATE TABLE tbl2_n12(key int, value string) CLUSTERED BY (key) SORTED BY (key) INTO 2 BUCKETS;

insert overwrite table tbl1_n13
select * from src where key < 10;

insert overwrite table tbl2_n12
select * from src where key < 10;

analyze table tbl1_n13 compute statistics;
analyze table tbl1_n13 compute statistics for columns; 

analyze table tbl2_n12 compute statistics;
analyze table tbl2_n12 compute statistics for columns;

set hive.optimize.bucketmapjoin = true;
set hive.optimize.bucketmapjoin.sortedmerge = true;
set hive.input.format = org.apache.hadoop.hive.ql.io.BucketizedHiveInputFormat;

set hive.auto.convert.sortmerge.join=true;

-- The join is being performed as part of sub-query. It should be converted to a sort-merge join
explain
select count(*) from (
  select a.key as key, a.value as val1, b.value as val2 from tbl1_n13 a join tbl2_n12 b on a.key = b.key
) subq1;

select count(*) from (
  select a.key as key, a.value as val1, b.value as val2 from tbl1_n13 a join tbl2_n12 b on a.key = b.key
) subq1;

-- The join is being performed as part of more than one sub-query. It should be converted to a sort-merge join
explain
select count(*) from
(
  select key, count(*) from 
  (
    select a.key as key, a.value as val1, b.value as val2 from tbl1_n13 a join tbl2_n12 b on a.key = b.key
  ) subq1
  group by key
) subq2;

select count(*) from
(
  select key, count(*) from 
  (
    select a.key as key, a.value as val1, b.value as val2 from tbl1_n13 a join tbl2_n12 b on a.key = b.key
  ) subq1
  group by key
) subq2;

-- A join is being performed across different sub-queries, where a join is being performed in each of them.
-- Each sub-query should be converted to a sort-merge join.
explain
select src1.key, src1.cnt1, src2.cnt1 from
(
  select key, count(*) as cnt1 from 
  (
    select a.key as key, a.value as val1, b.value as val2 from tbl1_n13 a join tbl2_n12 b on a.key = b.key
  ) subq1 group by key
) src1
join
(
  select key, count(*) as cnt1 from 
  (
    select a.key as key, a.value as val1, b.value as val2 from tbl1_n13 a join tbl2_n12 b on a.key = b.key
  ) subq2 group by key
) src2
on src1.key = src2.key;

select src1.key, src1.cnt1, src2.cnt1 from
(
  select key, count(*) as cnt1 from 
  (
    select a.key as key, a.value as val1, b.value as val2 from tbl1_n13 a join tbl2_n12 b on a.key = b.key
  ) subq1 group by key
) src1
join
(
  select key, count(*) as cnt1 from 
  (
    select a.key as key, a.value as val1, b.value as val2 from tbl1_n13 a join tbl2_n12 b on a.key = b.key
  ) subq2 group by key
) src2
on src1.key = src2.key;

-- The subquery itself is being joined. Since the sub-query only contains selects and filters, it should 
-- be converted to a sort-merge join.
explain
select count(*) from 
  (select a.key as key, a.value as value from tbl1_n13 a where key < 6) subq1 
    join
  (select a.key as key, a.value as value from tbl2_n12 a where key < 6) subq2
  on subq1.key = subq2.key;

select count(*) from 
  (select a.key as key, a.value as value from tbl1_n13 a where key < 6) subq1 
    join
  (select a.key as key, a.value as value from tbl2_n12 a where key < 6) subq2
  on subq1.key = subq2.key;

-- The subquery itself is being joined. Since the sub-query only contains selects and filters, it should 
-- be converted to a sort-merge join, although there is more than one level of sub-query
explain
select count(*) from 
  (
  select * from
    (
      select a.key as key, a.value as value from tbl1_n13 a where key < 8
    ) subq1 
  where key < 6
  ) subq2
  join tbl2_n12 b
  on subq2.key = b.key;

select count(*) from 
  (
  select * from
    (
      select a.key as key, a.value as value from tbl1_n13 a where key < 8
    ) subq1 
  where key < 6
  ) subq2
  join tbl2_n12 b
  on subq2.key = b.key;

-- Both the tables are nested sub-queries i.e more then 1 level of sub-query.
-- The join should be converted to a sort-merge join
explain
select count(*) from 
  (
  select * from
    (
      select a.key as key, a.value as value from tbl1_n13 a where key < 8
    ) subq1 
  where key < 6
  ) subq2
  join
  (
  select * from
    (
      select a.key as key, a.value as value from tbl1_n13 a where key < 8
    ) subq3 
  where key < 6
  ) subq4
  on subq2.key = subq4.key;

select count(*) from 
  (
  select * from
    (
      select a.key as key, a.value as value from tbl1_n13 a where key < 8
    ) subq1 
  where key < 6
  ) subq2
  join
  (
  select * from
    (
      select a.key as key, a.value as value from tbl1_n13 a where key < 8
    ) subq3 
  where key < 6
  ) subq4
  on subq2.key = subq4.key;

-- The subquery itself is being joined. Since the sub-query only contains selects and filters and the join key
-- is not getting modified, it should be converted to a sort-merge join. Note that the sub-query modifies one 
-- item, but that is not part of the join key.
explain
select count(*) from 
  (select a.key as key, concat(a.value, a.value) as value from tbl1_n13 a where key < 8) subq1 
    join
  (select a.key as key, concat(a.value, a.value) as value from tbl2_n12 a where key < 8) subq2
  on subq1.key = subq2.key;

select count(*) from 
  (select a.key as key, concat(a.value, a.value) as value from tbl1_n13 a where key < 8) subq1 
    join
  (select a.key as key, concat(a.value, a.value) as value from tbl2_n12 a where key < 8) subq2
  on subq1.key = subq2.key;

-- Since the join key is modified by the sub-query, neither sort-merge join not bucketized map-side
-- join should be performed
explain
select count(*) from 
  (select a.key +1 as key, concat(a.value, a.value) as value from tbl1_n13 a) subq1 
    join
  (select a.key +1 as key, concat(a.value, a.value) as value from tbl2_n12 a) subq2
  on subq1.key = subq2.key;

select count(*) from 
  (select a.key +1 as key, concat(a.value, a.value) as value from tbl1_n13 a) subq1 
    join
  (select a.key +1 as key, concat(a.value, a.value) as value from tbl2_n12 a) subq2
  on subq1.key = subq2.key;

-- One of the tables is a sub-query and the other is not.
-- It should be converted to a sort-merge join.
explain
select count(*) from 
  (select a.key as key, a.value as value from tbl1_n13 a where key < 6) subq1 
    join tbl2_n12 a on subq1.key = a.key;

select count(*) from 
  (select a.key as key, a.value as value from tbl1_n13 a where key < 6) subq1 
    join tbl2_n12 a on subq1.key = a.key;

-- There are more than 2 inputs to the join, all of them being sub-queries. 
-- It should be converted to to a sort-merge join
explain
select count(*) from 
  (select a.key as key, a.value as value from tbl1_n13 a where key < 6) subq1 
    join
  (select a.key as key, a.value as value from tbl2_n12 a where key < 6) subq2
  on (subq1.key = subq2.key)
    join
  (select a.key as key, a.value as value from tbl2_n12 a where key < 6) subq3
  on (subq1.key = subq3.key);

select count(*) from 
  (select a.key as key, a.value as value from tbl1_n13 a where key < 6) subq1 
    join
  (select a.key as key, a.value as value from tbl2_n12 a where key < 6) subq2
  on subq1.key = subq2.key
    join
  (select a.key as key, a.value as value from tbl2_n12 a where key < 6) subq3
  on (subq1.key = subq3.key);

-- The join is being performed on a nested sub-query, and an aggregation is performed after that.
-- The join should be converted to a sort-merge join
explain
select count(*) from (
  select subq2.key as key, subq2.value as value1, b.value as value2 from
  (
    select * from
    (
      select a.key as key, a.value as value from tbl1_n13 a where key < 8
    ) subq1
    where key < 6
  ) subq2
join tbl2_n12 b
on subq2.key = b.key) a;

select count(*) from (
  select subq2.key as key, subq2.value as value1, b.value as value2 from
  (
    select * from
    (
      select a.key as key, a.value as value from tbl1_n13 a where key < 8
    ) subq1
    where key < 6
  ) subq2
join tbl2_n12 b
on subq2.key = b.key) a;

-- The join is followed by a multi-table insert. It should be converted to
-- a sort-merge join
explain select a.key as key, a.value as val1, b.value as val2 from tbl1_n13 a join tbl2_n12 b on a.key = b.key;

select a.key as key, a.value as val1, b.value as val2 from tbl1_n13 a join tbl2_n12 b on a.key = b.key;

-- The join is followed by a multi-table insert, and one of the inserts involves a reducer.
-- It should be converted to a sort-merge join
explain select a.key as key, a.value as val1, b.value as val2 from tbl1_n13 a join tbl2_n12 b on a.key = b.key;

select a.key as key, a.value as val1, b.value as val2 from tbl1_n13 a join tbl2_n12 b on a.key = b.key;

