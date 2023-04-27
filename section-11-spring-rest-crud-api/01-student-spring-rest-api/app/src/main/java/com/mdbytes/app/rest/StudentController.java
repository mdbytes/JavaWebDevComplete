package com.mdbytes.app.rest;

import com.mdbytes.app.dao.StudentDAO;
import com.mdbytes.app.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    private StudentDAO studentDAO;

    @Autowired
    public StudentController(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return studentDAO.getAll();
    }

    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable("id") int id) {
        if (studentDAO.get(id) == null) {
            throw new StudentNotFoundException("Student with id " + id + " could not be found.");
        }
        return studentDAO.get(id);
    }

}
