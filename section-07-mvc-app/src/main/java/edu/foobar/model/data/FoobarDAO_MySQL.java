package edu.foobar.model.data;

import edu.foobar.model.Student;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FoobarDAO_MySQL implements FoobarDAO {
  private DataSource dataSource;

  private Connection myConn = null;
  private PreparedStatement ps = null;
  private ResultSet myRs = null;

  public FoobarDAO_MySQL(DataSource theDataSource) {
    dataSource = theDataSource;
  }

  @Override
  public void addStudent(String firstName, String lastName, String email) {
    try {
      String sql = "insert into student (first_name, last_name, email) VALUES (?,?,?)";
      myConn = dataSource.getConnection();
      ps = myConn.prepareStatement(sql);
      ps.setString(1, firstName);
      ps.setString(2, lastName);
      ps.setString(3, email);
      ps.executeUpdate();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      close(myConn, ps, myRs);
    }
  }

  @Override
  public Student getStudent(int id) {
    Student student = null;
    try {
      String sql = "select * from student where id=?";
      myConn = dataSource.getConnection();
      ps = myConn.prepareStatement(sql);
      ps.setInt(1, id);
      myRs = ps.executeQuery();
      while(myRs.next()) {
        int studentId = myRs.getInt("id");
        String firstName = myRs.getString("first_name");
        String lastName = myRs.getString("last_name");
        String email = myRs.getString("email");
        student = new Student(studentId,firstName,lastName,email);
        return student;
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      close(myConn, ps, myRs);
    }
    return null;
  }

  @Override
  public List<Student> getStudents() {
    List<Student> students = new ArrayList<>();

    try {
      myConn = dataSource.getConnection();
      String sql = "select * from student order by last_name";
      ps = myConn.prepareStatement(sql);
      myRs = ps.executeQuery();
      while (myRs.next()) {
        int id = myRs.getInt("id");
        String firstName = myRs.getString("first_name");
        String lastName = myRs.getString("last_name");
        String email = myRs.getString("email");
        Student student = new Student(id, firstName, lastName, email);
        students.add(student);
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      close(myConn, ps, myRs);
    }
    return students;
  }

  @Override
  public List<Student> getStudents(String name) {
    List<Student> students = new ArrayList<>();

    try {
      myConn = dataSource.getConnection();
      String sql = "select * from student where last_name = ? or first_name= ?";
      ps.setString(1,name);
      ps.setString(2,name);
      ps = myConn.prepareStatement(sql);
      myRs = ps.executeQuery();
      while (myRs.next()) {
        int id = myRs.getInt("id");
        String firstName = myRs.getString("first_name");
        String lastName = myRs.getString("last_name");
        String email = myRs.getString("email");
        Student student = new Student(id, firstName, lastName, email);
        students.add(student);
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      close(myConn, ps, myRs);
    }
    return students;
  }

  @Override
  public void updateStudent(Student student) {
    try {
      String sql = "update student set first_name=?, last_name=?, email=? where id=?";
      myConn = dataSource.getConnection();
      ps = myConn.prepareStatement(sql);
      ps.setString(1, student.getFirstName());
      ps.setString(2, student.getLastName());
      ps.setString(3, student.getEmailAddress());
      ps.setInt(4, student.getId());
      ps.executeUpdate();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      close(myConn, ps, myRs);
    }
  }

  @Override
  public void deleteStudent(int studentId) {

    try {
      String sql = "delete from student where id=?";
      myConn = dataSource.getConnection();
      ps = myConn.prepareStatement(sql);
      ps.setInt(1,studentId);
      ps.executeUpdate();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      close(myConn, ps, myRs);
    }
  }

  private void close(Connection myConn, PreparedStatement ps, ResultSet myRs) {
    try {
      if (myRs != null) myRs.close();
      if (ps != null) ps.close();
      if (myConn != null) myConn.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
