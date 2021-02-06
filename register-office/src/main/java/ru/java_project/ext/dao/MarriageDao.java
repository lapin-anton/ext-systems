package ru.java_project.ext.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.java_project.ext.domain.MarriageCertificate;
import ru.java_project.ext.view.MarriageRequest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class MarriageDao {

    private static final Logger logger = LoggerFactory.getLogger(MarriageDao.class);

    private EntityManager entityManager;

    public MarriageDao() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistence");
        entityManager = factory.createEntityManager();
    }

    public MarriageCertificate findMarriageCertificate(MarriageRequest request) {
        logger.info("find marriage certificate started");
        Query query = entityManager.createNamedQuery("MarriageCertificate.findCertificate");
        query.setParameter("husbandSurname", request.getHusbandSurname());
        query.setParameter("husbandGivenname", request.getHusbandGivenname());
        query.setParameter("husbandPatronymic", request.getHusbandPatronymic());
        query.setParameter("husbandDateOfBirth", request.getHusbandDateOfBirth());

        query.setParameter("wifeSurname", request.getWifeSurname());
        query.setParameter("wifeGivenname", request.getWifeGivenname());
        query.setParameter("wifePatronymic", request.getWifePatronymic());
        query.setParameter("wifeDateOfBirth", request.getWifeDateOfBirth());

        return (MarriageCertificate) query.getSingleResult();
    }
}
