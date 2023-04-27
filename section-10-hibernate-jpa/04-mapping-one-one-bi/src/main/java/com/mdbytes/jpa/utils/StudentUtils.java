package com.mdbytes.jpa.utils;

import com.mdbytes.jpa.dao.student.StudentDAO;
import com.mdbytes.jpa.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentUtils {

    private StudentDAO studentDAO;

    private int testStudentId = 37;

    @Autowired
    public StudentUtils(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    public void testStudentDAO() {
        // Create
        // createMultipleStudents(studentDAO);

        // Retrieve
        // readStudent(studentDAO);
        // queryForStudents(studentDAO);
        // queryForStudentsByLastName(studentDAO);

        // Update
        // updateStudent(studentDAO);

        // Delete
        // deleteStudent(studentDAO);
        // deleteAllStudents(studentDAO);
    }

    private void deleteAllStudents(StudentDAO studentDAO) {
        int n = studentDAO.deleteAll();
        System.out.println(n);
    }

    private void deleteStudent(StudentDAO studentDAO) {
        int studentId = testStudentId;
        System.out.println("Deleting student");
        studentDAO.delete(testStudentId);

    }

    private void updateStudent(StudentDAO studentDAO) {
        Student student = studentDAO.get(testStudentId);
        System.out.println(student);

        student.setLastName("Axelrod");
        studentDAO.update(student);

        Student newStudent = studentDAO.get(1);
        System.out.println(newStudent);
    }

    private void queryForStudentsByLastName(StudentDAO studentDAO) {
        List<Student> students = studentDAO.getByLastName("Doe");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private void queryForStudents(StudentDAO studentDAO) {
        List<Student> students = studentDAO.getAll();
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private void readStudent(StudentDAO studentDAO) {

        // create a student object
        System.out.println("Creating student");
        Student student = new Student("Daffy", "Duck", "daffy@mdbytes.com");

        // save the student
        studentDAO.save(student);

        // display id of the saved student
        System.out.println(student.getId());

        // retrieve the student based on id
        Student newStudent = studentDAO.get(testStudentId);

        System.out.println(newStudent);

        // display student
    }


    private void createMultipleStudents(StudentDAO studentDAO) {

        // create the student object
        System.out.println("Creating student objects...");

        Student student = new Student("John", "Doe", "john@mdbytes.com");
        Student student2 = new Student("Jane", "Doe", "jane@mdbytes.com");
        Student student3 = new Student("Jimmy", "Doe", "jimmy@mdbytes.com");
        Student student4 = new Student("Jack", "Doe", "jack@mdbytes.com");

        // save the student object
        System.out.println("Saving...");
        studentDAO.save(student);
        studentDAO.save(student2);
        studentDAO.save(student3);
        studentDAO.save(student4);

        // display the id of the student
        System.out.println("Saved student.  Generated Id: " + student.getId());
        System.out.println("Saved student.  Generated Id: " + student2.getId());
        System.out.println("Saved student.  Generated Id: " + student3.getId());
        System.out.println("Saved student.  Generated Id: " + student4.getId());

    }

}
