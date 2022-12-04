package com.example.sap_project;

import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class ResponseHandler {

    private static String closeDocument = "</body></html>";
    static PrintWriter out;

    public static void setPrintWriter(HttpServletResponse response)
            throws IOException
    {
        out = response.getWriter();
    }

    public static void openDocument(String heading, String title)
    {
        out.println("<html>");
        out.println("<head>");
        out.println("<title>" + title +"</title>");
        out.println("<style> body{ background-color: #ddd;</style>");
        out.println("</head>");
        out.println("<body>");
    }

    public static void addParagraph(String add)
    {
        out.println("<p>" + add + "</p>");
    }

    public static void closeDocument()
    {
        out.println(closeDocument);
        out.flush();
    }
}
