package com.mdbytes.crud.demo.service;

import com.mdbytes.crud.demo.entity.Instructor;
import com.mdbytes.crud.demo.repository.InstructorRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class AppServiceImpl implements AppService {

    private InstructorRepository instructorRepository;

    @Autowired
    public AppServiceImpl(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
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
    public void delete(int id) {
        instructorRepository.deleteById(id);
    }


}
