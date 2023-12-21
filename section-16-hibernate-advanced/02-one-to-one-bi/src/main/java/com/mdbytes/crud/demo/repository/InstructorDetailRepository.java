package com.mdbytes.crud.demo.repository;

import com.mdbytes.crud.demo.entity.InstructorDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IntructorDetailRepository extends JpaRepository<InstructorDetail,Integer> {
}
