package ru.java_project.ext.dao;

import org.junit.Assert;
import org.junit.Test;
import ru.java_project.ext.domain.Person;
import ru.java_project.ext.domain.PersonFemale;
import ru.java_project.ext.domain.PersonMale;

import java.util.List;

public class PersonDaoTest {

    @Test
    public void findPersons() {
        PersonDao dao = new PersonDao();
        List<Person> persons = dao.findPersons();
        persons.forEach(person -> {
            System.out.println(person.getFirstName());
            System.out.println(person.getClass().getName());
            System.out.println(person.getPassports().size());
            System.out.println(person.getBirthCertificate());
            if(person instanceof PersonMale) {
                System.out.println(((PersonMale) person).getMarriageCertificates().size());
                System.out.println(((PersonMale) person).getBirthCertificates().size());

            }
            if(person instanceof PersonFemale) {
                System.out.println(((PersonFemale) person).getMarriageCertificates().size());
                System.out.println(((PersonFemale) person).getBirthCertificates().size());
            }
        });
    }
}