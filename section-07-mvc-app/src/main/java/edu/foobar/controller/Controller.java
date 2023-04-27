package edu.foobar.controller;

import edu.foobar.model.Student;
import edu.foobar.model.data.FoobarDAO_MySQL;
import jakarta.annotation.Resource;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Controller", value = "/main")
public class Controller extends HttpServlet {

  private FoobarDAO_MySQL foobarDAOMySQL;

  @Resource(name = "jdbc/web_student_tracker")
  private DataSource dataSource;

  @Override
  public void init() throws ServletException {
    super.init();

    // create instance of student db util
    try {
      foobarDAOMySQL = new FoobarDAO_MySQL(dataSource);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String actionType = request.getParameter("action-type") != null ? request.getParameter("action-type") : "list-students";
    RequestDispatcher dispatcher = null;

    switch (actionType) {
      case "list-students":
        listStudents(request, response);
        break;

      case "add-student":
        dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/students/add-student.jsp");
        dispatcher.forward(request, response);
        break;

      case "update-student":
        getUpdateStudent(request, response, dispatcher);
        break;

      case "delete-student":
        foobarDAOMySQL.deleteStudent(Integer.parseInt(request.getParameter("id")));
        response.sendRedirect(request.getContextPath()+ "/main");
        break;
    }
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String actionType = request.getParameter("action-type") != null ? request.getParameter("action-type") : "list-students";

    switch (actionType) {
      case "add-student":
        addStudent(request, response);
        listStudents(request, response);

      case "update-student":
        updateStudent(request, response);
        response.sendRedirect(request.getContextPath()+ "/main");
    }
  }

  private void getUpdateStudent(HttpServletRequest request, HttpServletResponse response, RequestDispatcher dispatcher) {
    Student student = foobarDAOMySQL.getStudent(Integer.parseInt(request.getParameter("id")));
    try {
      if (student != null) {
        request.setAttribute("student", student);
        dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/students/update-student.jsp");
        dispatcher.forward(request, response);
      } else {
        dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/students/list-students.jsp");
        dispatcher.forward(request, response);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }


  private void updateStudent(HttpServletRequest request, HttpServletResponse response) {

    int studentId = Integer.parseInt(request.getParameter("id"));

    String firstName = request.getParameter("firstName");
    String lastName = request.getParameter("lastName");
    String email = request.getParameter("email");
    Student student = new Student(studentId, firstName, lastName, email);

    try {
      foobarDAOMySQL.updateStudent(student);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }


  private void listStudents(HttpServletRequest request, HttpServletResponse response) {
    try {
      List<Student> students = foobarDAOMySQL.getStudents();
      request.setAttribute("students", students);
      RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/students/list-students.jsp");
      dispatcher.forward(request, response);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void addStudent(HttpServletRequest request, HttpServletResponse response) {
    String firstName = request.getParameter("firstName");
    String lastName = request.getParameter("lastName");
    String email = request.getParameter("email");

    try {
      foobarDAOMySQL.addStudent(firstName, lastName, email);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
