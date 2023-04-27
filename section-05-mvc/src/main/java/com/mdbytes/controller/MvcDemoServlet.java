package com.mdbytes.controller;

import com.mdbytes.model.Student;
import com.mdbytes.model.data.StudentDataUtils;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "MvcDemoServlet", value = "/MvcDemoServlet")
public class MvcDemoServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    // add data
    StudentDataUtils data = new StudentDataUtils();
    List<Student> students = data.getStudents();
    request.setAttribute("student_list", students);

    // get request dispatcher
    RequestDispatcher dispatcher = request.getRequestDispatcher("/view_students.jsp");

    // forward request to jsp
    dispatcher.forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }
}
