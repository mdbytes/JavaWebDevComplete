package edu.foobar.model.data;

import jakarta.annotation.Resource;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet(name = "TestJdbcServlet", value = "/TestJdbcServlet")
public class TestJdbcServlet extends HttpServlet {
  // Get a reference to the connection pool
  @Resource(name = "jdbc/web_student_tracker")
  private DataSource dataSource;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    PrintWriter out = response.getWriter();

    response.setContentType("text/plain");

    Connection myConn = null;
    Statement myStmt = null;
    ResultSet myRs = null;

    try {

      myConn = dataSource.getConnection();

      String sql = "select * from student";

      myStmt = myConn.createStatement();

      myRs = myStmt.executeQuery(sql);

      while(myRs.next()) {
        String email = myRs.getString("email");
        out.println(email);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
