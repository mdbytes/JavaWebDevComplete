package com.mdbytes.springboot.crud.dao;

import com.mdbytes.springboot.crud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="employees")
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    // that's all needed to implement crud ops for Employee
}
