CREATE SEQUENCE global_seq;

CREATE TABLE "users" (
  id INTEGER  PRIMARY KEY DEFAULT nextval('global_seq'),
  name TEXT NOT NULL ,
  age  INTEGER ,
  isAdmin BOOLEAN DEFAULT FALSE,
  createdDate TIMESTAMP DEFAULT now()
);

INSERT INTO "users"(name,age) VALUES ('john',28);