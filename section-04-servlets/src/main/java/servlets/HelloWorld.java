package servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HelloWorld", value = "/HelloWorld")
public class HelloWorld extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // step 1: set the content type
        response.setContentType("text/html");

        // step 2: get a printwriter
        PrintWriter out = response.getWriter();

        // step 3: generate html code
        out.println("<html><body>");
        out.println("<h2>Hello World!</h2>");
        out.println("<hr/>");
        out.println("<p>Time on the server is: " + new java.util.Date() + "</p>");
      out.println("</body></html>");
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }
}
