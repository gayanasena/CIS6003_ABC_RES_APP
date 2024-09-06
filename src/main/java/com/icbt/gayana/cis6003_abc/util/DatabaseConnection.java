package com.icbt.gayana.cis6003_abc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/cis6003";
    private static final String USER = "gayana";
    private static final String PASSWORD = "Gaya@123";
    private static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver"; // MySQL driver

    // Method to get a connection to the database
    public static Connection getConnection() {
        Connection connection = null;
        try {
            // Load the JDBC driver
            Class.forName(DRIVER_CLASS);
            // Create a connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    // Method to close the database connection
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
