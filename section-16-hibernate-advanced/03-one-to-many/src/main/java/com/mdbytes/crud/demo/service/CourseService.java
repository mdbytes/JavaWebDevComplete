package com.mdbytes.crud.demo.service;

import com.mdbytes.crud.demo.entity.Course;
import com.mdbytes.crud.demo.entity.Instructor;

import java.util.List;

public interface CourseService {
    void save(Course course);

    Course findCourseById(Integer id);

    void deleteById(int id);

    List<Course> findAll();
}
