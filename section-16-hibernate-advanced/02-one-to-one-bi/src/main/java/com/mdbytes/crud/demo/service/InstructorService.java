package com.mdbytes.crud.demo.service;

import com.mdbytes.crud.demo.entity.Instructor;

public interface AppService {
    void save(Instructor instructor);

    Instructor findInstructorById(Integer id);

    void delete(int i);
}
