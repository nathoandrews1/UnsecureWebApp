package com.example.sap_project_apache;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(name="sqlInjectionServlet", value="/sqlInjectionServlet")
public class SQLInjectionServlet extends HttpServlet {

    private String firstname,lastname;

    public void init(){

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException
    {
        response.setContentType("text/html");
        ResponseHandler.setPrintWriter(response);
        Connection connection = DatabaseConnection.connectDatabase();

        firstname = request.getParameter("username");
        lastname = request.getParameter("password");

        //Search database below
        try {

            //Here we provide the parameters required for the PreparedStatement instead of just executing the query without
            ResultSet rs = searchQuery(firstname,lastname);

            //If results are found

            while (rs.next()) {
                ResponseHandler.addParagraph("User Found: " + firstname + " " + lastname);
                ResponseHandler.addParagraph("Role:" + rs.getString("role") + " Salary:" + rs.getString("salary"));
            }
            RequestDispatcher dis = request.getRequestDispatcher("sqlPage.jsp");
            dis.include(request, response);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        ResponseHandler.closeDocument();
    }

    public ResultSet searchQuery(String firstname, String lastname){
        try{

            //Updated here to protect the select statement with a PreparedStatement instead.
            //PreparedStatement will define the parameters and id them properly.
            //In the background it makes sure that no extra or noless  parameters can be injected.
            //This is one known mechanism to prevent SQL Injection
            String query = "SELECT * FROM staff WHERE firstname=? AND lastname=?";

            PreparedStatement statement = DatabaseConnection.connectDatabase().prepareStatement(query);
            statement.setString(1,firstname);
            statement.setString(2, lastname);
            ResultSet rs = statement.executeQuery();
            return rs;
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
