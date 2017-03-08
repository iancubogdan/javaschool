DROP TABLE company IF EXISTS;
CREATE TABLE company (
  id bigint NOT NULL AUTO_INCREMENT,
  company_name VARCHAR(300),
  PRIMARY KEY (id)
);

DROP TABLE employee IF EXISTS;
CREATE TABLE employee (
  id bigint NOT NULL AUTO_INCREMENT,
  firstname VARCHAR(300),
  lastname VARCHAR(300),
  company_id bigint,
  PRIMARY KEY (id),
  CONSTRAINT company_id_fk FOREIGN KEY (company_id) REFERENCES company(id)
);

