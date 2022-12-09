package com.example.sap_project_apache;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.*;

public class DatabaseConnection {

    private static PrintWriter responseWriter;
    static private String connectionURL = "jdbc:postgresql://ec2-34-253-119-24.eu-west-1.compute.amazonaws.com:5432/d1rrv36groamcf";
    static private String user = "buttcbudodjukm";
    static private String password = "56e9b205f9521916df49a046d794a54ce7db693c4feb903b5736a75053053dc4";

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


    //Created a function to close the connection of the static and input connection
    public static void closeConnection(Connection conect)
    {
        connection = conect;
        try{
            if(connection.isClosed() == false)
            {
                connection.close();
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
