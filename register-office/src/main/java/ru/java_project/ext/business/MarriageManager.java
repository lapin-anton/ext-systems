package ru.java_project.ext.business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.java_project.ext.dao.MarriageDao;
import ru.java_project.ext.domain.MarriageCertificate;
import ru.java_project.ext.view.MarriageRequest;
import ru.java_project.ext.view.MarriageResponse;

public class MarriageManager {

    private static final Logger logger = LoggerFactory.getLogger(MarriageManager.class);

    private MarriageDao marriageDao;

    public void setMarriageDao(MarriageDao marriageDao) {
        this.marriageDao = marriageDao;
    }

    public MarriageResponse findMarriageCertificate(MarriageRequest request) {
        logger.info("find marriage certificate started");
        MarriageCertificate certificate = marriageDao.findMarriageCertificate(request);

        return new MarriageResponse();
    }
}
