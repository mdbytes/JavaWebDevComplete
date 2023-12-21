package com.mdbytes.crud.demo.repository;

import com.mdbytes.crud.demo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Integer> {

}
