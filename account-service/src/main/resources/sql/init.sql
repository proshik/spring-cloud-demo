BEGIN TRANSACTION;

DROP TABLE IF EXISTS "account" CASCADE;
DROP SEQUENCE IF EXISTS "account_seq";

---------------------------------------------------------

CREATE SEQUENCE "account_seq";
CREATE TABLE "account" (

  --   "id"           BIGINT PRIMARY KEY,
  "username"     TEXT NOT NULL PRIMARY KEY,
  "created_date" TIMESTAMP WITH TIME ZONE,
  "password"     TEXT NOT NULL,
  CONSTRAINT "username_unique" UNIQUE (username)
);

END TRANSACTION;