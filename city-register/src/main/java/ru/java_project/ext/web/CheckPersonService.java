package ru.java_project.ext.web;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/check")
public class CheckPersonService {

    @GET
    public String checkPerson() {
        return "simple string";
    }
}
