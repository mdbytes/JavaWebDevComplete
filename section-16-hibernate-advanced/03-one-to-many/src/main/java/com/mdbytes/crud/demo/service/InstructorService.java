package com.mdbytes.crud.demo.service;

import com.mdbytes.crud.demo.entity.Course;
import com.mdbytes.crud.demo.entity.Instructor;

import java.util.List;

public interface InstructorService {
    void save(Instructor instructor);

    Instructor findInstructorById(Integer id);

    void deleteById(int i);

    Instructor populateInstructorCourses(Instructor instructor);

    void deleteInstructor(Instructor instructor);
}
