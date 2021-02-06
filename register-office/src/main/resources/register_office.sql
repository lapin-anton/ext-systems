DROP TABLE IF EXISTS ro_marriage_certificate;
DROP TABLE IF EXISTS ro_birth_certificate;
DROP TABLE IF EXISTS ro_passport;
DROP TABLE IF EXISTS ro_person;

CREATE TABLE ro_person (
    person_id integer not null AUTO_INCREMENT,
    sex smallint not null,
    first_name varchar(100) not null ,
    last_name varchar(100) not null ,
    patronymic varchar(100),
    date_of_birth date not null,

    PRIMARY KEY (person_id)
);

CREATE TABLE ro_passport (
    passport_id integer not null AUTO_INCREMENT,
    person_id integer not null,
    seria varchar(10) not null,
    number varchar(20) not null,
    issue_date date not null,
    issue_department varchar(200),

    PRIMARY KEY (passport_id),
    FOREIGN KEY (person_id) REFERENCES ro_person(person_id) ON DELETE RESTRICT
);

CREATE TABLE ro_birth_certificate (
    birth_certificate_id integer not null AUTO_INCREMENT,
    number varchar(20) not null,
    issue_date date not null,
    person_id integer not null,
    father_id integer,
    mother_id integer,

    PRIMARY KEY (birth_certificate_id),
    FOREIGN KEY (person_id) REFERENCES ro_person(person_id) ON DELETE RESTRICT,
    FOREIGN KEY (father_id) REFERENCES ro_person(person_id) ON DELETE RESTRICT,
    FOREIGN KEY (mother_id) REFERENCES ro_person(person_id) ON DELETE RESTRICT
);

CREATE TABLE ro_marriage_certificate (
    marriage_certificate_id integer not null AUTO_INCREMENT,
    number varchar(20) not null,
    issue_date date not null,
    husband_id integer not null,
    wife_id integer not null,
    active boolean DEFAULT true,
    end_date date,

    PRIMARY KEY (marriage_certificate_id),
    FOREIGN KEY (husband_id) REFERENCES ro_person(person_id) ON DELETE RESTRICT,
    FOREIGN KEY (wife_id) REFERENCES ro_person(person_id) ON DELETE RESTRICT
);

INSERT INTO ro_person(sex, first_name, last_name, patronymic, date_of_birth)
VALUES (1, 'Анна', 'Иванова', 'Ивановна', '1998-02-28'),
       (2, 'Иван', 'Иванов', 'Иванович', '1997-03-09'),
       (2, 'Николай', 'Иванов', 'Иванович', '2017-02-18');

INSERT INTO ro_passport(person_id, seria, number, issue_date, issue_department)
VALUES (1, '1234', '567890', '2018-03-12', 'Отдел полиции 1'),
       (2, '4321', '098765', '2017-04-25', 'Отдел полиции 2');

INSERT INTO ro_marriage_certificate(number, issue_date, husband_id, wife_id)
VALUES ('987654', '2016-04-23', 2, 1);

INSERT INTO ro_birth_certificate(number, issue_date, person_id, father_id, mother_id)
VALUES ('12345678', '2017-02-20', 3, 2, 1);