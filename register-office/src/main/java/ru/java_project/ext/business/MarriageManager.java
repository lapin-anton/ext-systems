package ru.java_project.ext.business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import ru.java_project.ext.dao.MarriageDao;
import ru.java_project.ext.dao.PersonDao;
import ru.java_project.ext.domain.MarriageCertificate;
import ru.java_project.ext.domain.Person;
import ru.java_project.ext.domain.PersonFemale;
import ru.java_project.ext.domain.PersonMale;
import ru.java_project.ext.view.MarriageRequest;
import ru.java_project.ext.view.MarriageResponse;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service("marriageService")
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class MarriageManager {

    private static final Logger logger = LoggerFactory.getLogger(MarriageManager.class);

    @Autowired
    private MarriageDao marriageDao;

    @Autowired
    private PersonDao personDao;

    @Transactional
    public MarriageResponse findMarriageCertificate(MarriageRequest request) {
        logger.info("find marriage certificate started");
        //MarriageCertificate certificate = marriageDao.findMarriageCertificate(request);
        //
        //List<Person> persons = personDao.findPersons();
        personDao.addPerson(getPerson(1));
        personDao.addPerson(getPerson(2));
        MarriageCertificate certificate = getMarriageCertificate();
        marriageDao.saveAndFlush(certificate);
        List<MarriageCertificate> certificates = marriageDao.findAll();
        certificates.forEach(crt -> System.out.println(crt));
        //TODO: to make realization for response
        return new MarriageResponse();
    }

    private MarriageCertificate getMarriageCertificate() {
        MarriageCertificate mc = new MarriageCertificate();
        mc.setNumber("123456");
        mc.setIssueDate(LocalDate.now());
        List<Person> persons = personDao.findPersons();
        for (Person p: persons) {
            if (p instanceof PersonMale) {
                mc.setHusband((PersonMale) p);
            } else {
                mc.setWife((PersonFemale) p);
            }
        }
        return mc;
    }

    private Person getPerson(int sex) {
        Person p = null;
        if(sex == 1) {
            p = new PersonMale();
            p.setFirstName("Перт");
            p.setLastName("Петров");
            p.setPatronymic("Петрович");
            p.setDateOfBirth(LocalDate.of(1996, 3, 5));
        } else {
            p = new PersonFemale();
            p.setFirstName("Анна");
            p.setLastName("Петрова");
            p.setPatronymic("Петровна");
            p.setDateOfBirth(LocalDate.of(1997, 4, 6));
        }
        return p;
    }
}
