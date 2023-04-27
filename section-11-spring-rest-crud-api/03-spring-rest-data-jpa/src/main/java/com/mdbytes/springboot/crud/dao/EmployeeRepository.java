package com.mdbytes.springboot.crud.dao;

import com.mdbytes.springboot.crud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    // that's all needed to implement crud ops for Employee
}
