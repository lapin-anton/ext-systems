package ru.java_project.ext.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.java_project.ext.business.MarriageManager;
import ru.java_project.ext.view.MarriageRequest;
import ru.java_project.ext.view.MarriageResponse;

@Service("controller")
public class MarriageController {
    private static final Logger logger = LoggerFactory.getLogger(MarriageController.class);

    @Autowired
    @Qualifier("marriageService")
    private MarriageManager marriageManager;

    public MarriageResponse findMarriageCertificate(MarriageRequest request) {
        logger.info("find marriage certificate started");
        return marriageManager.findMarriageCertificate(request);
    }
}
