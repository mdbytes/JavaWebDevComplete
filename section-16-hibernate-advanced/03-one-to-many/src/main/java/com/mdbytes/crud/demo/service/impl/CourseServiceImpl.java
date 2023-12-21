package com.mdbytes.crud.demo.service.impl;

import com.mdbytes.crud.demo.entity.Course;
import com.mdbytes.crud.demo.repository.CourseRepository;
import com.mdbytes.crud.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private CourseRepository courseRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public void save(Course course) {
        courseRepository.save(course);
    }

    @Override
    public Course findCourseById(Integer id) {
        return courseRepository.findById(id).get();
    }

    @Override
    public void deleteById(int id) {
        courseRepository.deleteById(id);
    }

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public List<Course> findCoursesByInstructorId(Integer id) {
        return courseRepository.findCoursesByInstructorId(id);
    }

    @Override
    public void deleteCourse(Course course) {
            course.setInstructor(null);
            courseRepository.save(course);
            courseRepository.delete(course);
    }
}
