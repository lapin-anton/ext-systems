INSERT INTO sr_university (university_name) VALUES ('University One');

INSERT INTO sr_faculty (faculty_name, university_id)
    VALUES ('Faculty One', 1);

INSERT INTO sr_student (first_name, last_name, middle_name, date_of_birth, passport_seria, passport_number, passport_date)
    VALUES ('First', 'Last', 'Middle', '1995-03-05', '1234', '567890', '2015-04-08');

INSERT INTO sr_student_document (document_number, document_date, expired_date, student_form, faculty_id, student_id)
    VALUES ('111111', '2013-09-1', '2017-05-31', 0, 1, 1);