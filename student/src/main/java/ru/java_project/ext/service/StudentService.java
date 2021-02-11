package ru.java_project.ext.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.java_project.ext.dao.StudentRepository;
import ru.java_project.ext.domain.Student;
import ru.java_project.ext.domain.StudentDocument;
import ru.java_project.ext.view.StudentRequest;
import ru.java_project.ext.view.StudentResponse;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private static final Logger LOGGER = LoggerFactory.getLogger(StudentService.class);

    @Autowired
    private StudentRepository repository;

    @Transactional
    public List<StudentResponse> getStudentInfo(StudentRequest request) {
        LOGGER.info("getStudentInfo called");
        List<Student> studentInfo = repository.findStudent(
                request.getFirstName(),
                request.getLastName(),
                request.getMiddleName(),
                request.getDateOfBirth(),
                request.getPassportSeria(),
                request.getPassportNumber(),
                request.getPassportDate()
        );

        if (studentInfo.isEmpty()) {
            return Collections.emptyList();
        }
        List<StudentDocument> documents = studentInfo.get(0).getDocuments();
        List<StudentResponse> result = documents.stream().map(d -> getResponse(d)).collect(Collectors.toList());
        return result;
    }

    private StudentResponse getResponse(StudentDocument document) {
        StudentResponse response = new StudentResponse();
        response.setDocumentNumber(document.getDocumentNumber());
        response.setDocumentDate(document.getDocumentDate());
        response.setExpiredDate(document.getExpiredDate());
        response.setUniversity(document.getFaculty().getUniversity().getUniversityName());
        response.setFacultyName(document.getFaculty().getFacultyName());
        response.setStudentForm(document.getStudentForm().toString());
        return response;
    }
}
