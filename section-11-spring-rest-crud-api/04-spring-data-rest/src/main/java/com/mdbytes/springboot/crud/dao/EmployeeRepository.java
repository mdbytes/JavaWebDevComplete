package com.mdbytes.springboot.crud.dao;

import com.mdbytes.springboot.crud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;


@Repository
//@RepositoryRestResource(path="members")
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    // that's all needed to implement crud ops for Employee
}
