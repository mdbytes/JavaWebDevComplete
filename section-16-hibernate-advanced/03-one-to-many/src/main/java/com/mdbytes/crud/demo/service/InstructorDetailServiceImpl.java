package com.mdbytes.crud.demo.service;

import com.mdbytes.crud.demo.entity.InstructorDetail;
import com.mdbytes.crud.demo.repository.InstructorDetailRepository;
import org.springframework.stereotype.Service;

@Service
public class InstructorDetailServiceImpl implements InstructorDetailService {

    private InstructorDetailRepository instructorDetailRepository;

    public InstructorDetailServiceImpl(InstructorDetailRepository instructorDetailRepository) {
        this.instructorDetailRepository = instructorDetailRepository;
    }

    @Override
    public void save(InstructorDetail detail) {
        instructorDetailRepository.save(detail);
    }

    @Override
    public InstructorDetail findById(Integer id) {
        return instructorDetailRepository.findById(id).get();
    }

    @Override
    public void deleteById(Integer id) {
        instructorDetailRepository.deleteById(id);
    }
}
