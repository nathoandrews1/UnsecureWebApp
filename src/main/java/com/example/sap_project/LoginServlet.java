package com.example.sap_project;

import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.xml.crypto.Data;

@WebServlet(name = "loginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    public void init() {

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        ResponseHandler.setPrintWriter(response);
        ResponseHandler.openDocument("","login");
        Connection connection = DatabaseConnection.connectDatabase();

        String user = request.getParameter("username");
        String password = request.getParameter("password");
        String searchQuery = "SELECT * FROM login WHERE username='"+user+"' AND password='"+password+"'";

        ResultSet rs = DatabaseConnection.queryDatabase(searchQuery);
        try {
            if(rs.next())
            {
                //Found staff member
                String email = rs.getString("email");
                String FIND_STAFF_QUERY = "SELECT * FROM staff WHERE email='"+email+"'";
                ResultSet findStaffRs = DatabaseConnection.queryDatabase(FIND_STAFF_QUERY);

                //If the result set has a value it exists. Increment and call the value
                if(findStaffRs.next()) {
                    ResponseHandler.addParagraph("Welcome Back " + findStaffRs.getString("firstname") + " " +
                            findStaffRs.getString("lastname"));
                }

                //Redirect after 1 second to logged in page for user
                response.setHeader("refresh","2;index.jsp");;
            }
            else {
                //Not found
                ResponseHandler.addParagraph("User not found or password was wrong, try again");
                ResponseHandler.addParagraph("Redirecting...");
                response.setHeader("refresh","2;loginPage.jsp");
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

        ResponseHandler.closeDocument();
    }

    public void destroy() {
    }
}