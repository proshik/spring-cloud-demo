BEGIN TRANSACTION;

DROP TABLE IF EXISTS "users" CASCADE;
DROP SEQUENCE IF EXISTS "users_seq";

---------------------------------------------------------

CREATE SEQUENCE "users_seq";
CREATE TABLE "users" (
  "id"            BIGINT PRIMARY KEY       DEFAULT "nextval"('"users_seq"'),
  "created_date"  TIMESTAMP WITH TIME ZONE,
  "username"      TEXT    NOT NULL,
  "password"      TEXT    NOT NULL,
  "enabled"       BOOLEAN NOT NULL         DEFAULT TRUE,
  CONSTRAINT "username_unique" UNIQUE (username)
);

END TRANSACTION;