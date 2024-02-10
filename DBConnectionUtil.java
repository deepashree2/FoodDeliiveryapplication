package com.foodDeliveryApp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionUtil {

    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/foodDeliveryApp";
    private static final String DATABASE_USER = "root";
    private static final String DATABASE_PASSWORD = "Xworkzodc@123";
    
    private static Connection con = null;
    
    // Private constructor to prevent instantiation
    private DBConnectionUtil() {
    }

    public static Connection getConnection() {
        try {
            // Check if the connection is null or closed
            if (con == null || con.isClosed()) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
                System.out.println("Connected to the database!");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
}