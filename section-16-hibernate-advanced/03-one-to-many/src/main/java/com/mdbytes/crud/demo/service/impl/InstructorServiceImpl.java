package com.mdbytes.crud.demo.service.impl;

import com.mdbytes.crud.demo.entity.Course;
import com.mdbytes.crud.demo.entity.Instructor;
import com.mdbytes.crud.demo.repository.CourseRepository;
import com.mdbytes.crud.demo.repository.InstructorRepository;
import com.mdbytes.crud.demo.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class InstructorServiceImpl implements InstructorService {

    private InstructorRepository instructorRepository;

    private CourseRepository courseRepository;

    @Autowired
    public InstructorServiceImpl(InstructorRepository instructorRepository, CourseRepository courseRepository) {
        this.instructorRepository = instructorRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    @Transactional
    public void save(Instructor instructor) {
        instructorRepository.save(instructor);
    }

    @Override
    public Instructor findInstructorById(Integer id) {
        return instructorRepository.findById(id).get();
    }

    @Override
    public void deleteById(int id) {
        instructorRepository.deleteById(id);
    }

    @Override
    public Instructor populateInstructorCourses(Instructor instructor) {
        List<Course> courses = courseRepository.findCoursesByInstructorId(instructor.getId());
        instructor.setCourses(courses);
        return instructor;
    }

    @Override
    public void deleteInstructor(Instructor instructor) {
        List<Course> courses = courseRepository.findCoursesByInstructorId(instructor.getId());
        for(Course course: courses) {
            course.setInstructor(null);
            courseRepository.save(course);
        }
        instructorRepository.delete(instructor);
    }


}
