package com.mdbytes.test;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "TestServlet", value = "/test")
public class TestServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set response content type
      response.setContentType("text/html");

      // Actual logic goes here.
      PrintWriter out = response.getWriter();
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<title>Test Servlet</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>Hello Servlet</h1>");
      out.println("<p>This is the test servlet</p>");
      String linkHome = "http://localhost:8080/aop";
      out.println("<a href='" + linkHome + "'>Back to Home</a>");
      out.println("</body>");
      out.println("</html>");
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }
}
