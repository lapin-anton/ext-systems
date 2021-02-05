package ru.java_project.ext.manager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.java_project.ext.domain.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class PersonManager {
    public static void main(String[] args) {
        sessionExample();

        jpaExample();
    }

    private static void jpaExample() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Person person = new Person();
        person.setFirstName("Donald");
        person.setLastName("Trump");

        em.persist(person);
        System.out.println(person.getPersonId());
        em.getTransaction().commit();

        em = emf.createEntityManager();
        List<Person> persons = em.createQuery("FROM Person", Person.class).getResultList();
        persons.forEach(p -> System.out.println(p));
        em.close();
    }

    private static void sessionExample() {
        SessionFactory sessionFactory = buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();

        Person person = new Person();
        person.setFirstName("John");
        person.setLastName("Smith");

        Long id = (Long) session.save(person);

        session.getTransaction().commit();
        session.close();
        System.out.println(id);
        session = sessionFactory.openSession();
        Person p = session.get(Person.class, id);
        System.out.println(p);
        session.close();

        session = sessionFactory.openSession();
        List<Person> persons = session.createQuery("FROM Person", Person.class).list();
        for (Person per: persons) {
            System.out.println(per);
        }
        session.close();
    }


    private static SessionFactory buildSessionFactory() {
        try {
            StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .configure("hibernate.cfg.xml").build();

            Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();

            return metadata.getSessionFactoryBuilder().build();
        } catch (Throwable ex) {

            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
}
