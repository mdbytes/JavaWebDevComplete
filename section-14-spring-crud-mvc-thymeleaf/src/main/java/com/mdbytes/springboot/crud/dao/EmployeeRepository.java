package com.mdbytes.springboot.crud.dao;

import com.mdbytes.springboot.crud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // that's all needed to implement crud ops for Employee

    public List<Employee> findAllByOrderByLastNameAsc();
}
