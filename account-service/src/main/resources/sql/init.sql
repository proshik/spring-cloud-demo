BEGIN TRANSACTION;

DROP TABLE IF EXISTS "account" CASCADE;
DROP SEQUENCE IF EXISTS "account_seq";

---------------------------------------------------------

CREATE SEQUENCE "account_seq";
CREATE TABLE "account" (

  "id"           BIGINT PRIMARY KEY,
  "created_date" TIMESTAMP WITH TIME ZONE,
  "username"     TEXT NOT NULL,
  "password"     TEXT NOT NULL
);

END TRANSACTION;