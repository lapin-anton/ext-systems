package ru.java_project.ext.dao;

import org.springframework.stereotype.Component;
import ru.java_project.ext.domain.Person;

import javax.persistence.*;
import java.util.List;

@Component
public class PersonDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Person> findPersons() {
        return entityManager
                .createNamedQuery("Person.findPersons")
                .getResultList();
    }

    public Long addPerson(Person person) {
        entityManager.persist(person);
        entityManager.flush();
        return person.getPersonId();
    }
}
