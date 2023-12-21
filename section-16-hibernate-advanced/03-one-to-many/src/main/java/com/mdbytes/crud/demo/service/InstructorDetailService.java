package com.mdbytes.crud.demo.service;

import com.mdbytes.crud.demo.entity.InstructorDetail;

public interface InstructorDetailService {

    void save(InstructorDetail detail);

    InstructorDetail findById(Integer id);

    void deleteById(Integer id);
}
