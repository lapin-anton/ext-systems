package ru.java_project.ext.dao;

import ru.java_project.ext.domain.PersonRequest;
import ru.java_project.ext.domain.PersonResponse;
import ru.java_project.ext.exception.PersonCheckException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonCheckDao {

    private static final String SQL_REQUEST = "";


    public PersonResponse checkPerson(PersonRequest personRequest) throws PersonCheckException {
        PersonResponse response = new PersonResponse();
        try (Connection con = getConnection();
             PreparedStatement stmt = con.prepareStatement(SQL_REQUEST)) {

            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                response.setRegistered(true);
                response.setTemporal(rs.getBoolean("temporal"));
            } else {
                response.setRegistered(false);
                response.setTemporal(false);
            }
        } catch (SQLException e) {
            throw new PersonCheckException(e.getMessage(), e);
        }
        return response;
    }

    private Connection getConnection() {
        return null;
    }
}
