package com.mdbytes.crud.demo.repository;

import com.mdbytes.crud.demo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course,Integer> {
    List<Course> findCoursesByInstructorId(Integer instructorId);
}
