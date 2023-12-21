package com.mdbytes.crud.demo;

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
	public CommandLineRunner commandLineRunner(InstructorService appService, InstructorDetailService instructorDetailService) {

		return runner -> {
			//createInstructorDetail(instructorDetailService);
			//createInstructor(appService);
			//findInstructorDetail(1,instructorDetailService);
			//deleteInstructor(2,appService);
			deleteInstructorDetail(1,instructorDetailService);

		};
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
