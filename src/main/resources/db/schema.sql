DROP TABLE employee IF EXISTS;
CREATE TABLE employee (
  id bigint NOT NULL AUTO_INCREMENT,
  firstname VARCHAR(300),
  lastname VARCHAR(300),
  PRIMARY KEY (id)
);