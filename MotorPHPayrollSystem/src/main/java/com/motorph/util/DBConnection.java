package com.motorph.util;

import java.sql.*;
import java.util.Properties;
import java.io.*;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/payrollsystem_db";
    private static final String USER = "madie";
    private static final String PASSWORD = "catskittenMEOWS7times"; 

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
