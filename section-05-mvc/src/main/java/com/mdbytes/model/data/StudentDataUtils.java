package com.mdbytes.model.data;

import com.mdbytes.model.Student;

import java.util.ArrayList;

public class StudentDataUtils {
  private ArrayList<Student> students;

  public StudentDataUtils() {
    students = StudentDataUtils.getStudentData();
  }

  private static ArrayList<Student> getStudentData() {
    ArrayList<Student> newStudents = new ArrayList<>();
    newStudents.add(new Student("Martin","Dwyer","martin@mdbytes.com"));
    newStudents.add(new Student("John","Smith","john@mdbytes.com"));
    newStudents.add(new Student("Fred","Flintstone","fred@mdbytes.com"));
    newStudents.add(new Student("Barney","Rubble","barney@mdbytes.com"));
    newStudents.add(new Student("Jill","Janson","jill@mdbytes.com"));
    return newStudents;
  }

  public ArrayList<Student> getStudents() {
    return students;
  }
}
