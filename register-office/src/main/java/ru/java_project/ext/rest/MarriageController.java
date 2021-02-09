package ru.java_project.ext.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import ru.java_project.ext.business.MarriageManager;
import ru.java_project.ext.view.MarriageRequest;
import ru.java_project.ext.view.MarriageResponse;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.awt.*;

@Service("controller")
@Path("/mc")
public class MarriageController {
    private static final Logger logger = LoggerFactory.getLogger(MarriageController.class);

    @Autowired
    @Qualifier("marriageService")
    private MarriageManager marriageManager;
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public MarriageResponse findMarriageCertificate() {
        logger.info("find marriage certificate started");
        return marriageManager.findMarriageCertificate(null);
    }
}
