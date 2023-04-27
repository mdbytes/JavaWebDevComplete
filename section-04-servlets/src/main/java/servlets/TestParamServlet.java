package servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "TestParamServlet", value = "/TestParamServlet")
public class TestParamServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      // set content type
      response.setContentType("text/html");

      // get printwriter
      PrintWriter out = response.getWriter();

      // read param information
      ServletContext context = getServletContext();
      String maxParam = context.getInitParameter("max-shopping-cart-size");
      String groupName = context.getInitParameter("project-team-name");

      // generate html content
      out.println("<html><body>");

      out.println("Max shopping cart size: " + maxParam);

      out.println("Project team name: " + groupName);

      out.println("</body></html>");
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }
}
