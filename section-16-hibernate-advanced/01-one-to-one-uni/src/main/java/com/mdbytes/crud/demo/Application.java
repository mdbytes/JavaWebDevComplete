package com.mdbytes.crud.demo;

import com.mdbytes.crud.demo.service.AppService;
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
	public CommandLineRunner commandLineRunner(AppService appService) {

		return runner -> {
			// createInstructor(appService);
			// findInstructor(2,appService);
			deleteInstructor(2,appService);
		};
	}

	private void deleteInstructor(int i, AppService appService) {
		appService.delete(1);
	}

	private void findInstructor(int i, AppService appService) {
		Instructor instructor = appService.findInstructorById(2);
		System.out.println(instructor);

	}

	private void createInstructor(AppService appService) {
		// create instructor
		Instructor instructor = new Instructor("Marty","Dwyer","marty@luv2code.com");
		InstructorDetail detail = new InstructorDetail("http://www.luv2code/youtube","Luvs 2 code!!!");
		instructor.setDetail(detail);

		// save the instructor
		System.out.println(instructor);
		appService.save(instructor);

		System.out.println("done with new instructor");

	}

}
