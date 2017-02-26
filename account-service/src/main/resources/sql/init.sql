BEGIN TRANSACTION;

DROP TABLE IF EXISTS "account" CASCADE;
DROP SEQUENCE IF EXISTS "account_seq";

DROP TABLE IF EXISTS "users" CASCADE;
DROP SEQUENCE IF EXISTS "users_seq";

---------------------------------------------------------

CREATE SEQUENCE "account_seq";
CREATE TABLE "account" (

  "id"            BIGINT PRIMARY KEY       DEFAULT "nextval"('"account_seq"'),
  "email"         TEXT NOT NULL,
  "confirm_email" BOOLEAN,
  "first_name"    TEXT,
  "last_name"     TEXT,
  CONSTRAINT "email_unique" UNIQUE (email)
);

CREATE SEQUENCE "users_seq";
CREATE TABLE "users" (
  "id"           BIGINT PRIMARY KEY       DEFAULT "nextval"('"users_seq"'),
  "created_date" TIMESTAMP WITH TIME ZONE,
  "username"     TEXT    NOT NULL,
  "password"     TEXT    NOT NULL,
  "enabled"      BOOLEAN NOT NULL         DEFAULT TRUE,
  "account_id"   BIGINT  NOT NULL REFERENCES account ("id"),
  CONSTRAINT "username_unique" UNIQUE (username)
);

END TRANSACTION;