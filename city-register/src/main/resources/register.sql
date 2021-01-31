DROP TABLE IF EXISTS cr_address_person;
DROP TABLE IF EXISTS cr_person;
DROP TABLE IF EXISTS cr_address;
DROP TABLE IF EXISTS cr_street;
DROP TABLE IF EXISTS cr_district;

CREATE TABLE cr_district
(
    district_code integer not null,
    district_name varchar(300),
    PRIMARY KEY (district_code)
);

INSERT INTO cr_district (district_code, district_name)
VALUES (1, 'Выборгский');

CREATE TABLE cr_street
(
    street_code integer not null,
    street_name varchar(300),
    PRIMARY KEY (street_code)
);

INSERT INTO cr_street (street_code, street_name)
VALUES (1, 'Сампсоньевский проспект');

CREATE TABLE cr_address
(
    address_id    integer     not null AUTO_INCREMENT,
    district_code integer     not null,
    street_code   integer     not null,
    building      varchar(10) not null,
    extension     varchar(10),
    apartment     varchar(10),
    PRIMARY KEY (address_id),
    FOREIGN KEY (district_code) REFERENCES cr_district (district_code) ON DELETE RESTRICT,
    FOREIGN KEY (street_code) REFERENCES cr_street (street_code) ON DELETE RESTRICT
);

INSERT INTO cr_address (district_code, street_code, building, extension, apartment)
VALUES (1, 1, '10', '2', '121');

CREATE TABLE cr_person
(
    person_id          integer      not null AUTO_INCREMENT,
    sur_name           varchar(100) not null,
    given_name         varchar(100) not null,
    patronymic         varchar(100) not null,
    date_of_birth      date         not null,
    passport_seria     varchar(10),
    passport_number    varchar(10),
    passport_date      date,
    certificate_number VARCHAR(10),
    certificate_date   date,
    PRIMARY KEY (person_id)
);

INSERT INTO cr_person (sur_name, given_name, patronymic, date_of_birth, passport_seria, passport_number, passport_date,
                       certificate_number, certificate_date)
VALUES ('Иванов', 'Иван', 'Иванович', '1993-02-28', '1234', '567890', '2013-03-12', null, null);

INSERT INTO cr_person (sur_name, given_name, patronymic, date_of_birth, passport_seria, passport_number, passport_date,
                       certificate_number, certificate_date)
VALUES ('Иванова', 'Анна', 'Ивановна', '1995-08-12', '0987', '654321', '2015-09-04', null, null);

INSERT INTO cr_person (sur_name, given_name, patronymic, date_of_birth, passport_seria, passport_number, passport_date,
                       certificate_number, certificate_date)
VALUES ('Иванов', 'Петр', 'Иванович', '2019-04-25', null, null, null, '123487', '2019-05-10');

INSERT INTO cr_person (sur_name, given_name, patronymic, date_of_birth, passport_seria, passport_number, passport_date,
                       certificate_number, certificate_date)
VALUES ('Иванова', 'Ирина', 'Ивановна', '2020-10-23', null, null, null, '456783', '2020-11-02');

CREATE TABLE cr_address_person
(
    person_address_id integer not null AUTO_INCREMENT,
    address_id        integer not null,
    person_id         integer not null,
    start_date        date    not null,
    end_date          date,
    PRIMARY KEY (person_address_id),
    FOREIGN KEY (address_id) REFERENCES cr_address (address_id) ON DELETE RESTRICT,
    FOREIGN KEY (person_id) REFERENCES cr_person (person_id) ON DELETE RESTRICT
);

INSERT INTO cr_address_person (address_id, person_id, start_date, end_date)
VALUES (1, 1, '2018-04-25', null);

INSERT INTO cr_address_person (address_id, person_id, start_date, end_date)
VALUES (1, 2, '2018-04-25', null);

INSERT INTO cr_address_person (address_id, person_id, start_date, end_date)
VALUES (1, 3, '2019-06-18', null);

INSERT INTO cr_address_person (address_id, person_id, start_date, end_date)
VALUES (1, 4, '2020-12-25', null);