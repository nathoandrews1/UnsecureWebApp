package com.example.sap_project;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.core.Response;

import java.io.IOException;
import java.sql.*;

@WebServlet(name = "registerUserServlet", value = "/registerUser")
public class RegisterUserServlet extends HttpServlet {

    private String firstname,lastname,salary,role,email,username,password;
    private String d = "default";
    private String[] staffProperties = {firstname,lastname,salary,role,email};
    private String[] accountProperties = {username,password,email};
    private boolean exists;
    Connection connection;
    @Override
    public void init() {

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        ResponseHandler.setPrintWriter(response);
        ResponseHandler.openDocument("","Register");
        connection = DatabaseConnection.connectDatabase();

        grabValuesFromRequest(request);
        insertIntoStaff();
        insertIntoLogin();
        validateRecordExists();

        if(exists)
        {
            ResponseHandler.addParagraph("Congratulations you're registered! Welcome "+ firstname + " " + lastname);
            ResponseHandler.addParagraph("You can now login, redirecting...");
            response.setHeader("refresh","2;loginPage.jsp");
        }
        else {
            ResponseHandler.addParagraph("Error adding user, please try again");
            response.setHeader("refresh","2;registerPage.jsp");
        }
    }

    private void grabValuesFromRequest(HttpServletRequest request)
    {
        firstname = request.getParameter("firstname");
        lastname = request.getParameter("lastname");
        salary = request.getParameter("salary");
        role = request.getParameter("role");
        email = request.getParameter("email");

        username = request.getParameter("username");
        password = request.getParameter("password");
    }

    private void insertIntoStaff()
    {
        validateRecordExists();

        if(!exists) {
            String query = "INSERT INTO staff (firstname, lastname, salary, role, username, email) VALUES (?, ?, ?, ?, ?, ?)";
            try {
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, firstname);
                statement.setString(2, lastname);
                statement.setString(3, salary);
                statement.setString(4, role);
                statement.setString(5, username);
                statement.setString(6, email);
                statement.executeUpdate();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void insertIntoLogin()
    {
            String query = "INSERT INTO login (username, password, email) VALUES (?, ?, ?)";
            try
            {
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, username);
                statement.setString(2, password);
                statement.setString(3, email);
                statement.executeUpdate();
                statement.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
    }

    public void validateRecordExists()
    {
        try {
            String searchQuery = "SELECT * FROM staff WHERE email ='" + email + "'";
            ResultSet rs = DatabaseConnection.queryDatabase(searchQuery);

            if (rs.next()) {
                //found result
                exists = true;
            }
            else{
                exists = false;
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
}
