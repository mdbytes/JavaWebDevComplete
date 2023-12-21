package com.mdbytes.crud.demo;

import com.mdbytes.crud.demo.entity.Course;
import com.mdbytes.crud.demo.service.CourseService;
import com.mdbytes.crud.demo.service.InstructorDetailService;
import com.mdbytes.crud.demo.service.InstructorService;
import com.mdbytes.crud.demo.entity.Instructor;
import com.mdbytes.crud.demo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(InstructorService instructorService, InstructorDetailService instructorDetailService, CourseService courseService) {

		return runner -> {

			/*
			 *   Uncomment one line below for each successive run to test functionality
			 */

			//appSetup(instructorService,instructorDetailService, courseService);
			//findInstructorWithCourses(instructorService);
			//updateInstructor(instructorService);
			//updateCourse(courseService);
			//deleteInstructor(instructorService);
			//deleteExistingCourse(courseService);
		};
	}

	private void deleteExistingCourse(CourseService courseService) {
		System.out.println("Deleting corporate finance");
		Course course = courseService.findCourseById(1);
		courseService.deleteCourse(course);
		System.out.println("done");
	}

	private void deleteInstructor(InstructorService instructorService) {
		System.out.println("Trying to delete instructor number 2");
		// Work is done in the service impl
		Instructor instructor = instructorService.findInstructorById(2);
		instructorService.deleteInstructor(instructor);
		System.out.println("Done");
	}

	private void updateCourse(CourseService courseService) {
		System.out.println("updating course");
		// Changing course title from Finance to Corporate Finance
		Course course = courseService.findCourseById(1);
		course.setTitle("Corporate Finance");
		courseService.save(course);
		System.out.println("Done");
	}

	private void updateInstructor(InstructorService instructorService) {

		System.out.println("Updating instructor");

		// Updating instructor 1 first name from Marty to Martin
		Instructor instructor = instructorService.findInstructorById(1);
		instructor.setFirstName("Martin");
		instructorService.save(instructor);
		System.out.println("Done");
	}

	private void findInstructorWithCourses(InstructorService instructorService) {
		Instructor instructor = instructorService.findInstructorById(1);

		// Retrieve the instructors courses and reset
		Instructor loadedInstructor = instructorService.populateInstructorCourses(instructor);

		// The following produces an exception because courses are a fetch type of lazy by default
		// Works fine when you change the fetch type to EAGER but this requires more processing and memory
		for(Course course : loadedInstructor.getCourses()){
			System.out.println(course);
		}

	}

	private void appSetup(InstructorService instructorService, InstructorDetailService instructorDetailService, CourseService courseService) {

		// Make instructors
		// create instructor
		Instructor instructor = new Instructor("Marty","Dwyer","marty@luv2code.com");
		InstructorDetail detail = new InstructorDetail("http://www.luv2code/youtube","Luvs 2 code!!!");
		instructor.setDetail(detail);

		// create instructor
		Instructor instructor2 = new Instructor("Chad","Darby","darby@luv2code.com");
		InstructorDetail detail2 = new InstructorDetail("http://www.luv2code/youtube","Luv 2 code!!!");
		instructor2.setDetail(detail2);


		System.out.println("done with new instructor");

		// Print instructors
		System.out.println(instructor);
		System.out.println(instructor2);

		// Make courses
		Course courseOne = new Course("Finance");
		Course courseTwo = new Course("Mathematics");
		Course courseThree = new Course("Computer Science");
		Course courseFour = new Course("Java");
		Course courseFive = new Course("Spring Boot");

		// Print courses
		System.out.println(courseOne);
		System.out.println(courseTwo);
		System.out.println(courseThree);
		System.out.println(courseFour);
		System.out.println(courseFive);

		// Assign courses to instructor 1
		courseOne.setInstructor(instructor);
		courseTwo.setInstructor(instructor);
		courseThree.setInstructor(instructor2);
		courseFour.setInstructor(instructor2);
		courseFive.setInstructor(instructor2);

		instructor.add(courseOne);
		instructor.add(courseTwo);
		instructor2.add(courseThree);
		instructor2.add(courseFour);

		// save the instructor
		instructorService.save(instructor);
		instructorService.save(instructor2);



		// Print out list of courses for instructor
		System.out.println("courses for instructor one");
		for(Course course : instructor.getCourses()){
			System.out.println(course);
		}
		System.out.println("courses for instructor two");
		for(Course course : instructor2.getCourses()){
			System.out.println(course);
		}


	}



}
