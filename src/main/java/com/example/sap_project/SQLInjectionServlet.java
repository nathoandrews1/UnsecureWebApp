package com.example.sap_project;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.io.PrintWriter;
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
            ResultSet rs = searchQuery(firstname,lastname);

            //If results are found

            while (rs.next()) {
                ResponseHandler.addParagraph("User Found: " + firstname + " " + lastname);
                ResponseHandler.addParagraph("Role:" + rs.getString("role") + " Salary:" + rs.getString("salary"));
            }

            //Closing the connection after results.
            connection.close();
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
