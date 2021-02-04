package ru.java_project.ext.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.java_project.ext.dao.PersonCheckDao;
import ru.java_project.ext.dao.PoolConnectionBuilder;
import ru.java_project.ext.domain.PersonRequest;
import ru.java_project.ext.domain.PersonResponse;
import ru.java_project.ext.exception.PersonCheckException;

import javax.annotation.PostConstruct;
import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/check")
@Singleton
public class CheckPersonService {

    private static final Logger logger = LoggerFactory.getLogger(CheckPersonService.class);

    private PersonCheckDao dao;

    @PostConstruct
    public void init() {
        logger.info("START");
        dao = new PersonCheckDao();
        dao.setConnectionBuilder(new PoolConnectionBuilder());
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public PersonResponse checkPerson(PersonRequest request) throws PersonCheckException {
        logger.info(request.toString());
        return dao.checkPerson(request);
    }
}
