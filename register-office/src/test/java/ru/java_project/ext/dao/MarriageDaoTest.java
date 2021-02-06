package ru.java_project.ext.dao;

import org.junit.Test;
import ru.java_project.ext.domain.MarriageCertificate;
import ru.java_project.ext.view.MarriageRequest;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class MarriageDaoTest {

    @Test
    public void findMarriageCertificate() {
        MarriageDao dao = new MarriageDao();
        MarriageRequest request = new MarriageRequest();
        request.setHusbandSurname("Иванов");
        request.setHusbandGivenname("Иван");
        request.setHusbandPatronymic("Иванович");
        request.setHusbandDateOfBirth(LocalDate.of(1997, 3, 9)); //1997-03-09

        request.setWifeSurname("Иванова");
        request.setWifeGivenname("Анна");
        request.setWifePatronymic("Ивановна");
        request.setWifeDateOfBirth(LocalDate.of(1998, 2, 28));//1998-02-28

        MarriageCertificate certificate = dao.findMarriageCertificate(request);
        System.out.println(certificate);
    }
}