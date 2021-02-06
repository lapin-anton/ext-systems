package ru.java_project.ext.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.java_project.ext.business.MarriageManager;
import ru.java_project.ext.view.MarriageRequest;
import ru.java_project.ext.view.MarriageResponse;

public class MarriageController {
    private static final Logger logger = LoggerFactory.getLogger(MarriageController.class);

    private MarriageManager marriageManager;

    public void setMarriageManager(MarriageManager marriageManager) {
        this.marriageManager = marriageManager;
    }

    public MarriageResponse findMarriageCertificate(MarriageRequest request) {
        logger.info("find marriage certificate started");
        return marriageManager.findMarriageCertificate(request);
    }
}
