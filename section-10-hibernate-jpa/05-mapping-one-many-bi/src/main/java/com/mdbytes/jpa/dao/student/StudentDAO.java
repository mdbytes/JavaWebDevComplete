package com.mdbytes.jpa.dao.student;

import com.mdbytes.jpa.dao.DAO;
import com.mdbytes.jpa.entity.Student;

import java.util.List;

public interface StudentDAO extends DAO<Student> {

    List<Student> getByLastName(String lastName);

}
