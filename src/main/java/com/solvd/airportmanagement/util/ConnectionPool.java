package com.solvd.airportmanagement.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionPool {

    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");

                connection = DriverManager.getConnection(
                        ConfigLoader.getUrl(),
                        ConfigLoader.getUsername(),
                        ConfigLoader.getPassword()
                );

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return connection;
    }
}
