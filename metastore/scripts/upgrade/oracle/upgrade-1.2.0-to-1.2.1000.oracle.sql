SELECT 'Upgrading MetaStore schema from 1.2.0 to 1.2.1000' AS Status from dual;

@023-HIVE-12807.oracle.sql;
@024-HIVE-12814.oracle.sql;
@025-HIVE-12816.oracle.sql;
@026-HIVE-12818.oracle.sql;
@027-HIVE-12819.oracle.sql;
@028-HIVE-12821.oracle.sql;
@029-HIVE-12822.oracle.sql;
@030-HIVE-12823.oracle.sql;
@031-HIVE-12381.oracle.sql;
@032-HIVE-12832.oracle.sql;

UPDATE VERSION SET SCHEMA_VERSION='1.2.1000', VERSION_COMMENT='Hive release version 1.2.1000' where VER_ID=1;
SELECT 'Finished upgrading MetaStore schema from 1.2.0 to 1.2.1000' AS Status from dual;
