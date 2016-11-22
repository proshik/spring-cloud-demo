BEGIN TRANSACTION;

DROP TABLE IF EXISTS "topic" CASCADE;
DROP SEQUENCE IF EXISTS "topic_seq";

DROP TABLE IF EXISTS "tag" CASCADE;
DROP SEQUENCE IF EXISTS "tag_seq";

---------------------------------------------------------

CREATE SEQUENCE "topic_seq";
CREATE TABLE "topic" (

  "id"           BIGINT PRIMARY KEY       DEFAULT "nextval"('topic_seq'),
  "created_date" TIMESTAMP WITH TIME ZONE DEFAULT "now"(),
  "title"        TEXT NOT NULL,
  "content"      TEXT NOT NULL,
  "content_type" INT  NOT NULL,
  "rating"       INT  NOT NULL,
  "show_count"   INT  NOT NULL
);

CREATE SEQUENCE "tag_seq";
CREATE TABLE "tag" (

  "id"           BIGINT PRIMARY KEY       DEFAULT "nextval"('tag_seq'),
  "created_date" TIMESTAMP WITH TIME ZONE,
  "title"        TEXT NOT NULL,
  CONSTRAINT "title_unique" UNIQUE (title)
);

CREATE TABLE "topic_tag" (

  "topic_id" BIGINT REFERENCES "topic" (id) NOT NULL,
  "tag_id"   BIGINT REFERENCES "tag" (id)   NOT NULL
);

END TRANSACTION;