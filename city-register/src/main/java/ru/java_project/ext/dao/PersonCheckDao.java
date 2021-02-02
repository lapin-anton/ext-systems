package ru.java_project.ext.dao;

import ru.java_project.ext.domain.PersonRequest;
import ru.java_project.ext.domain.PersonResponse;
import ru.java_project.ext.exception.PersonCheckException;

import java.sql.*;

public class PersonCheckDao {

    private static final String SQL_REQUEST =
            "SELECT temporal FROM cr_address_person ap " +
            "        INNER JOIN cr_person p ON p.person_id = ap.person_id " +
            "        INNER JOIN cr_address a ON a.address_id = ap.address_id " +
            "WHERE " +
            "        CURRENT_DATE >= ap.start_date and (CURRENT_DATE <= ap.end_date or ap.end_date is null) " +
            "        AND UPPER(p.sur_name) = UPPER(?) " +
            "        AND UPPER(p.given_name) = UPPER(?) " +
            "        AND UPPER(p.patronymic) = UPPER(?) " +
            "        AND p.date_of_birth = ? " +
            "        AND a.district_code = ? " +
            "        AND a.street_code = ? " +
            "        AND UPPER(a.building) = UPPER(?) ";

    private ConnectionBuilder connectionBuilder;

    public void setConnectionBuilder(ConnectionBuilder connectionBuilder) {
        this.connectionBuilder = connectionBuilder;
    }

    public PersonResponse checkPerson(PersonRequest personRequest) throws PersonCheckException {
        PersonResponse response = new PersonResponse();
        String sql = SQL_REQUEST;
        if(personRequest.getExtension() != null) {
            sql += "        AND UPPER(a.extension) = UPPER(?) ";
        } else {
            sql += "        AND a.extension is null ";
        }
        if(personRequest.getApartment() != null) {
            sql += "        AND UPPER(a.apartment) = UPPER(?) ";
        } else {
            sql += "        AND a.apartment is null ";
        }
        try (Connection con = getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            int count = 1;
            stmt.setString(count++, personRequest.getSurName());
            stmt.setString(count++, personRequest.getGivenName());
            stmt.setString(count++, personRequest.getPatronymic());
            stmt.setDate(count++, Date.valueOf(personRequest.getDateOfBirth()));
            stmt.setInt(count++, personRequest.getDistrictCode());
            stmt.setInt(count++, personRequest.getStreetCode());
            stmt.setString(count++, personRequest.getBuilding());
            if(personRequest.getExtension() != null) {
                stmt.setString(count++, personRequest.getExtension());
            }
            if(personRequest.getApartment() != null) {
                stmt.setString(count, personRequest.getApartment());
            }
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                response.setRegistered(true);
                response.setTemporal(rs.getBoolean("temporal"));
            }
        } catch (SQLException e) {
            throw new PersonCheckException(e.getMessage(), e);
        }
        return response;
    }

    private Connection getConnection() throws SQLException {
        return connectionBuilder.getConnection();
    }
}
