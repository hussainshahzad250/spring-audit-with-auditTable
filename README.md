# spring auditing with Audit Table
How to implement auditing with Audit table using Spring data Auditing


CREATE TABLE employee (
  id int(11) NOT NULL,
  create_date datetime DEFAULT NULL,
  created_by varchar(255) DEFAULT NULL,
  dept varchar(255) DEFAULT NULL,
  doj datetime DEFAULT NULL,
  last_modified_date datetime DEFAULT NULL,
  modified_by varchar(255) DEFAULT NULL,
  name varchar(255) DEFAULT NULL,
  salary double NOT NULL,
  PRIMARY KEY (id)
) ;

CREATE TABLE revinfo (
  rev int(11) NOT NULL AUTO_INCREMENT,
  revtstmp bigint(20) DEFAULT NULL,
  PRIMARY KEY (rev)
) ;

CREATE TABLE employee_aud (
  id int(11) NOT NULL,
  create_date datetime DEFAULT NULL,
  created_by varchar(255) DEFAULT NULL,
  dept varchar(255) DEFAULT NULL,
  doj datetime DEFAULT NULL,
  rev int(11) NOT NULL,
  revtype tinyint(4) DEFAULT NULL,
  last_modified_date datetime DEFAULT NULL,
  modified_by varchar(255) DEFAULT NULL,
  name varchar(255) DEFAULT NULL,
  salary double NOT NULL,
  PRIMARY KEY (id,rev),
  KEY FK118cwnbfk1ny0ttu4bfqmeh8q (rev),
  CONSTRAINT FK118cwnbfk1ny0ttu4bfqmeh8q FOREIGN KEY (rev) REFERENCES revinfo (rev)
);


