package com.mdbytes.jpa;

import com.mdbytes.jpa.dao.student.StudentDAO;
import com.mdbytes.jpa.entity.Student;
import com.mdbytes.jpa.utils.InstructorUtils;
import com.mdbytes.jpa.utils.StudentUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentUtils studentUtils, InstructorUtils instructorUtils) {
		return runner -> {
				studentUtils.testStudentDAO();
				instructorUtils.testInstructorDAO();
		};
	}

}
