package ru.java_project.ext.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DirectConnectionBuilder implements ConnectionBuilder {
    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/city_register?useUnicode=true&serverTimezone=UTC",
            "root", "1111");
    }
}
