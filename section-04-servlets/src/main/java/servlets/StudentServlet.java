package servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "StudentServlet", value = "/StudentServlet")
public class StudentServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    String firstName = request.getParameter("firstName");
    String lastName = request.getParameter("lastName");

    // set content type
    response.setContentType("text/html");

    // get printwriter
    PrintWriter out = response.getWriter();

    // generate html code
    out.println("<html><body>");

    out.println("The student is confirmed!");
    out.println("<br/>");
    out.println(firstName + " " + lastName);
    out.println("<br/>");
    out.println("</body></html>");


  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String firstName = request.getParameter("firstName");
    String lastName = request.getParameter("lastName");

    // set content type
    response.setContentType("text/html");

    // get printwriter
    PrintWriter out = response.getWriter();

    // generate html code
    out.println("<html><body>");

    out.println("The student is confirmed!");
    out.println("<br/>");
    out.println(firstName + " " + lastName);
    out.println("<br/>");
    out.println("</body></html>");

  }
}
