package com.mdbytes.test;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {
  public static void main(String[] args) {
    String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
    String user = "marty";
    String pass = "iv!\\CkQ=84AXMQ-";

    try {

      System.out.println("Connecting to database: " + jdbcUrl);

      Connection myConn = DriverManager.getConnection(jdbcUrl,user,pass);

      System.out.println("Connection successful! ");

    } catch(Exception e) {
      e.printStackTrace();
    }
  }
}
