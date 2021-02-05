DROP TABLE IF EXISTS person;

CREATE TABLE person (
    person_id integer not null AUTO_INCREMENT,
    first_name varchar(100),
    last_name varchar(100),
    PRIMARY KEY (person_id)
);