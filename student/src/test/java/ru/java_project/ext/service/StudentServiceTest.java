package ru.java_project.ext.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import ru.java_project.ext.rest.StudentController;
import ru.java_project.ext.view.StudentRequest;
import ru.java_project.ext.view.StudentResponse;

import java.time.LocalDate;
import java.util.List;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:springContext.xml"})
public class StudentServiceTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentServiceTest.class);

    @Autowired
    private StudentController controller;

    @Test
    public void studentInfo() {
        StudentRequest request = new StudentRequest();
        request.setFirstName("First");
        request.setLastName("Last");
        request.setMiddleName("Middle");
        request.setDateOfBirth(LocalDate.of(1995, 3, 5));
        request.setPassportSeria("1234");
        request.setPassportNumber("567890");
        request.setPassportDate(LocalDate.of(2015, 4, 8));
        List<StudentResponse> responseList = controller.getStudentInfo(request);
        Assert.assertTrue(responseList.size() > 0);
    }
}