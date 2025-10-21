package com.example;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        // try {
        // Class.forName("com.mysql.cj.jdbc.Driver");
        // Enumeration<Driver> drivers = DriverManager.getDrivers();

        // while (drivers.hasMoreElements()) {
        // System.out.println(drivers.nextElement().getClass().getName());
        // }

        // } catch (ClassNotFoundException e) {
        // System.out.println("Drive class not found, can't load the driver");
        // }

        databaseConnection("jdbc:mysql://localhost:3306/TestDatabase", "workbench_user", "SecurePass123!");
    }

    public static void databaseConnection(String url, String user, String password) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            if (connection != null) {
                System.out.println("Connected to the TestDatabase!");
            }
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
        }
    }
}
