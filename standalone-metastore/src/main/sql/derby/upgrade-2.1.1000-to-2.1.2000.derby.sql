-- Upgrade MetaStore schema from 2.1.1000 to 2.1.2000

-- RUN '044-HIVE-16997.derby.sql';
ALTER TABLE "APP"."PART_COL_STATS" ADD COLUMN "BIT_VECTOR" BLOB;

-- RUN '045-HIVE-16886.derby.sql';
INSERT INTO "APP"."NOTIFICATION_SEQUENCE" ("NNI_ID", "NEXT_EVENT_ID") SELECT * FROM (VALUES (1,1)) tmp_table WHERE NOT EXISTS ( SELECT "NEXT_EVENT_ID" FROM "APP"."NOTIFICATION_SEQUENCE");

UPDATE "APP".VERSION SET SCHEMA_VERSION='2.1.2000', VERSION_COMMENT='Hive release version 2.1.2000' where VER_ID=1;
