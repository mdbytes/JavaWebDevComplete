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
			runApp(instructorService,instructorDetailService, courseService);
		};
	}

	private void runApp(InstructorService instructorService, InstructorDetailService instructorDetailService, CourseService courseService) {

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

//		// Delete instructor
//		System.out.println("deleting instructor 2");
//		instructorService.delete(2);
//
//		// Verify no courses are deleted
//		System.out.println("Make sure courses still include Computer Science, Java, Spring Boot");
//		for(Course course : courseService.findAll()) {
//			System.out.println(course);
//		}

	}

	private void deleteInstructorDetail(int i, InstructorDetailService instructorDetailService) {
		instructorDetailService.deleteById(i);
	}


	private void findInstructorDetail(int i, InstructorDetailService instructorDetailService) {
		InstructorDetail detail = instructorDetailService.findById(i);
		System.out.println(detail);
		System.out.println(detail.getInstructor());
	}

	private void createInstructorDetail(InstructorDetailService instructorDetailService) {

		// create instructor
		InstructorDetail detail = new InstructorDetail("http://www.luv2code/youtube","Luvs 2 code!!!");
		Instructor instructor = new Instructor("Marty","Dwyer","marty@luv2code.com");
		detail.setInstructor(instructor);

		System.out.println(detail);
		instructorDetailService.save(detail);

		System.out.println("done with new detail");

	}

	private void deleteInstructor(int i, InstructorService appService, InstructorDetailService instructorDetailService) {
		appService.delete(1);
	}

	private void findInstructor(int i, InstructorService instructorService) {
		Instructor instructor = instructorService.findInstructorById(2);
		System.out.println(instructor);

	}

	private void createInstructor(InstructorService instructorService) {
		// create instructor
		Instructor instructor = new Instructor("Marty","Dwyer","marty@luv2code.com");
		InstructorDetail detail = new InstructorDetail("http://www.luv2code/youtube","Luvs 2 code!!!");
		instructor.setDetail(detail);

		// create instructor
		Instructor instructor2 = new Instructor("Chad","Darby","darby@luv2code.com");
		InstructorDetail detail2 = new InstructorDetail("http://www.luv2code/youtube","Luv 2 code!!!");
		instructor2.setDetail(detail2);

		// save the instructor
		System.out.println(instructor);
		instructorService.save(instructor);
		instructorService.save(instructor2);

		System.out.println("done with new instructor");

	}

}
