package ru.java_project.ext.dao;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import ru.java_project.ext.domain.PersonRequest;
import ru.java_project.ext.domain.PersonResponse;
import ru.java_project.ext.exception.PersonCheckException;

import java.time.LocalDate;

public class PersonCheckDaoTest extends TestCase {

    @Test
    public void testCheckPerson() throws PersonCheckException {
        PersonRequest request = new PersonRequest();
        request.setSurName("Иванов");
        request.setGivenName("Иван");
        request.setPatronymic("Иванович");
        request.setDateOfBirth(LocalDate.of(1993, 2, 28));
        request.setDistrictCode(1);
        request.setStreetCode(1);
        request.setBuilding("10");
        request.setExtension("2");
        request.setApartment("121");
        PersonCheckDao dao = new PersonCheckDao();
        dao.setConnectionBuilder(new DirectConnectionBuilder());
        PersonResponse response = dao.checkPerson(request);
        Assert.assertTrue(response.isRegistered());
        Assert.assertFalse(response.isTemporal());
    }

    @Test
    public void testCheckPerson2() throws PersonCheckException {
        PersonRequest request = new PersonRequest();
        request.setSurName("Иванова");
        request.setGivenName("Анна");
        request.setPatronymic("Ивановна");
        request.setDateOfBirth(LocalDate.of(1995, 8, 12));
        request.setDistrictCode(1);
        request.setStreetCode(1);
        request.setBuilding("10");
        PersonCheckDao dao = new PersonCheckDao();
        dao.setConnectionBuilder(new DirectConnectionBuilder());
        PersonResponse response = dao.checkPerson(request);
        Assert.assertFalse(response.isRegistered());
        Assert.assertFalse(response.isTemporal());
    }
}