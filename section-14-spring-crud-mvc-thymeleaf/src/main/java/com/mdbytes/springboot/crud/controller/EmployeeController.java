package com.mdbytes.springboot.crud.controller;

import com.mdbytes.springboot.crud.entity.Employee;
import com.mdbytes.springboot.crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {


    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService service) {
        this.employeeService = service;
    }

    @GetMapping("/list")
    public String listEmployees(Model model) {

        List<Employee> employeeList = employeeService.findAll();

        model.addAttribute("employees", employeeList);

        return "/employees/list";
    }

    @GetMapping("/employee-form")
    public String showEmployeeForm(Model model) {

        Employee employee = new Employee();

        model.addAttribute("employee", employee);

        return "/employees/employee-form";
    }

    @GetMapping("/update")
    public String updateEmployee(@RequestParam("id") int id, Model model) {

        Employee employee = employeeService.findById(id);

        model.addAttribute("employee", employee);

        return "/employees/employee-form";
    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("id") int id, Model model) {

        employeeService.deleteById(id);

        return "redirect:/employees/list";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("employee") Employee employee) {

        employeeService.save(employee);

        return "redirect:/employees/list";
    }


}
