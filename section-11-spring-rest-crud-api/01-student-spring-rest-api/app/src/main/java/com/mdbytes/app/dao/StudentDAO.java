package com.mdbytes.app.dao;


import com.mdbytes.app.entity.Student;

import java.util.List;

public interface StudentDAO extends DAO<Student> {

    List<Student> getByLastName(String lastName);

}
