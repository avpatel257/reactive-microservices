DROP TABLE vet IF EXISTS;


CREATE TABLE vet (
  id         INTEGER IDENTITY PRIMARY KEY,
  first_name VARCHAR(30),
  last_name  VARCHAR(30),
  speciality VARCHAR(80)
);
CREATE INDEX vets_last_name ON vet (last_name);
CREATE INDEX vets_specialty ON vet (speciality);