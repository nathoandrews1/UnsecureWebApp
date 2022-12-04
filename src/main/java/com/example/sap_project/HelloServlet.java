package com.example.sap_project;

import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.xml.crypto.Data;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        DatabaseConnection.connectDatabase();
        ResponseHandler.setPrintWriter(response);
        ResponseHandler.openDocument("Hello World","Hello World Page");
        ResponseHandler.addParagraph("Hello again");
        if(DatabaseConnection.connected)
        {
            ResponseHandler.addParagraph("Connected to Database <br>Schema name " + DatabaseConnection.dbName+"");
            ResultSet rs = DatabaseConnection.queryDatabase(DatabaseConnection.selectQuery);

            if(rs == null)
            {
                ResponseHandler.addParagraph("result set from query is null");
            }
            else {
                try {
                    while (rs.next()) {
                        ResponseHandler.addParagraph("Found user: " + rs.getString("firstname") + " " + rs.getString("lastname") + " " + rs.getString("role"));
                    }
                } catch (SQLException e) {
                    ResponseHandler.addParagraph("Error with select query on database");
                }
            }
        }
        if(DatabaseConnection.connected == false)
        {
            ResponseHandler.addParagraph("Not connected to Database");
        }
        ResponseHandler.closeDocument();
    }

    public void destroy() {
    }
}