package com.mdbytes.jpa.dao;

import com.mdbytes.jpa.entity.Student;

import java.util.List;

public interface StudentDAO extends DAO<Student> {

    List<Student> getByLastName(String lastName);

}
