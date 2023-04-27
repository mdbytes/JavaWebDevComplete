package com.mdbytes.springboot.crud.dao;

import com.mdbytes.springboot.crud.entity.Employee;

import java.util.List;

public interface EmployeeDAO {


    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);

    void delete(int id);
}
