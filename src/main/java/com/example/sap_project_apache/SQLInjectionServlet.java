package com.example.sap_project_apache;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
            ResultSet rs = searchQuery();

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

    public ResultSet searchQuery(){
        try{
            String query = "SELECT * FROM staff WHERE firstname='"+ firstname + "' AND lastname='" + lastname + "'";

            Statement statement = DatabaseConnection.connectDatabase().createStatement();
            ResultSet rs = statement.executeQuery(query);
            return rs;
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
