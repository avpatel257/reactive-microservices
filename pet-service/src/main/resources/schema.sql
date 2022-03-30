DROP TABLE pet IF EXISTS;

CREATE TABLE pet (
  id         INTEGER IDENTITY PRIMARY KEY,
  name       VARCHAR(30),
  birth_date DATE,
  type    VARCHAR(30) NOT NULL,
  owner_id   INTEGER
);
CREATE INDEX pets_name ON pet (name);
CREATE INDEX pets_type ON pet (type);
