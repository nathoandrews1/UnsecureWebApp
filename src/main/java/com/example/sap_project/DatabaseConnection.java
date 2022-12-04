package com.example.sap_project;

import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class DatabaseConnection {

    private static PrintWriter responseWriter;
    static private String connectionURL = "jdbc:postgresql://localhost:5433/SAP_Project";
    static private String user = "postgres";
    static private String password = "postgres";

    public static String selectQuery = "SELECT * FROM staff WHERE staffid = '3'";
    static Connection connection;

    public static boolean connected = false;
    public static String dbName;
    public static Connection connectDatabase()
    {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(connectionURL,user,password);
            connected = true;
            dbName = connection.getSchema();
            return connection;
        }
        catch(SQLException | ClassNotFoundException e)
        {
            connected = false;
            System.out.println("Error Connecting to database");
            e.printStackTrace();
        }
        return null;
    }

    public static ResultSet queryDatabase(String query)
    {
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            return resultSet;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }
    public static void getResponseWriter(HttpServletResponse response)
    {
        try{
            responseWriter = response.getWriter();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
