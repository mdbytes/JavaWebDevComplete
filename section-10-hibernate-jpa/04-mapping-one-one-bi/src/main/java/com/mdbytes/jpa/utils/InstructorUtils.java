package com.mdbytes.jpa.utils;

import com.mdbytes.jpa.dao.Instructor.InstructorDAO;
import com.mdbytes.jpa.dao.instructordetail.InstructorDetailDAO;
import com.mdbytes.jpa.entity.Instructor;
import com.mdbytes.jpa.entity.InstructorDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InstructorUtils {

    private InstructorDAO instructorDAO;
    private InstructorDetailDAO instructorDetailDAO;

    private int testInstructorId = 10;

    @Autowired
    public InstructorUtils(InstructorDAO instructorDAO, InstructorDetailDAO instructorDetailDAO) {
        this.instructorDAO = instructorDAO;
        this.instructorDetailDAO = instructorDetailDAO;
    }

    public void testInstructorDAO() {
        // Create
        //createMultipleInstructors(instructorDAO);

        // Retrieve
        // readInstructor(instructorDAO);
        // getInstructorDetail(instructorDetailDAO);
        // queryForInstructors(instructorDAO);

        // Update
        // updateInstructor(instructorDAO);

        // Delete
        // deleteInstructor(instructorDAO);
        // deleteInstructorDetail(instructorDetailDAO);
        // deleteAllInstructors(instructorDAO);
    }

    private void deleteInstructorDetail(InstructorDetailDAO instructorDetailDAO) {
        InstructorDetail detail = instructorDetailDAO.get(13);
        instructorDetailDAO.delete(detail.getId());
        // both instructor and instructor detail are deleted!
    }

    private void getInstructorDetail(InstructorDetailDAO instructorDetailDAO) {
        InstructorDetail detail = instructorDetailDAO.get(13);

        System.out.println(detail);
        System.out.println(detail.getInstructor());
    }

    private void deleteAllInstructors(InstructorDAO instructorDAO) {
        int n = instructorDAO.deleteAll();
        System.out.println(n);
    }

    private void deleteInstructor(InstructorDAO instructorDAO) {
        int instructorId = testInstructorId;
        System.out.println("Deleting instructor");
        instructorDAO.delete(testInstructorId);

    }

    private void updateInstructor(InstructorDAO instructorDAO) {
        Instructor instructor = instructorDAO.get(1);
        System.out.println(instructor);

        instructor.setLastName("Axelrod");
        instructorDAO.update(instructor);

        Instructor newInstructor = instructorDAO.get(1);
        System.out.println(newInstructor);
    }

    private void queryForInstructors(InstructorDAO instructorDAO) {
        List<Instructor> instructors = instructorDAO.getAll();
        for (Instructor instructor : instructors) {
            System.out.println(instructor);
        }
    }

    private void readInstructor(InstructorDAO instructorDAO) {

        // create a instructor object
        System.out.println("Creating instructor");
        Instructor instructor = new Instructor("Daffy", "Duck", "daffy@mdbytes.com");

        // save the instructor
        instructorDAO.save(instructor);

        // display id of the saved instructor
        System.out.println(instructor.getId());

        // retrieve the instructor based on id
        Instructor newInstructor = instructorDAO.get(1);

        System.out.println(newInstructor);

        // display instructor
    }


    private void createMultipleInstructors(InstructorDAO instructorDAO) {

        // create the instructor object
        System.out.println("Creating instructor objects...");

        Instructor instructor = new Instructor("John", "Doe", "john@mdbytes.com");
        instructor.setInstructorDetail(new InstructorDetail("https://youtube.com", "Collecting bottle caps"));

        Instructor instructor2 = new Instructor("Jane", "Doe", "jane@mdbytes.com");
        instructor2.setInstructorDetail(new InstructorDetail("https://youtube.com", "Collecting bottle caps"));

        Instructor instructor3 = new Instructor("Jimmy", "Doe", "jimmy@mdbytes.com");
        instructor3.setInstructorDetail(new InstructorDetail("https://youtube.com", "Collecting bottle caps"));

        Instructor instructor4 = new Instructor("Jack", "Doe", "jack@mdbytes.com");
        instructor4.setInstructorDetail(new InstructorDetail("https://youtube.com", "Collecting bottle caps"));

        // save the instructor object
        System.out.println("Saving...");
        instructorDAO.save(instructor);
        instructorDAO.save(instructor2);
        instructorDAO.save(instructor3);
        instructorDAO.save(instructor4);

        // display the id of the instructor
        System.out.println("Saved instructor.  Generated Id: " + instructor.getId());
        System.out.println("Saved instructor.  Generated Id: " + instructor2.getId());
        System.out.println("Saved instructor.  Generated Id: " + instructor3.getId());
        System.out.println("Saved instructor.  Generated Id: " + instructor4.getId());

    }

}
