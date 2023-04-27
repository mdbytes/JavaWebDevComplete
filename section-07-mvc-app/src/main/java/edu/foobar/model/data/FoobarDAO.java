package edu.foobar.model.data;

import edu.foobar.model.Student;

import java.util.List;

public interface FoobarDAO {
  public void addStudent(String firstName, String lastName, String email);
  public Student getStudent(int id);
  public List<Student> getStudents();
  public List<Student> getStudents(String name);
  public void updateStudent(Student student);
  public void deleteStudent(int studentId);

}
