package com.mdbytes.crud.demo.repository;

import com.mdbytes.crud.demo.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor,Integer> {

}
