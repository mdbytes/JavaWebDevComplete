package com.mdbytes.springboot.crud.controller;

import com.mdbytes.springboot.crud.entity.Employee;
import com.mdbytes.springboot.crud.service.EmployeeService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private EmployeeService employeeService;

	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		List<Employee> employees = employeeService.findAll();
		theModel.addAttribute("employees", employees);
		return "employees/list-employees";
	}

	@GetMapping("/add-employee")
	public String addEmployee(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee",employee);
		return "employees/add-employee";
	}

	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee")Employee employee) {
		employeeService.save(employee);
		return "redirect:/employees/list";
	}

	@GetMapping("/update-employee")
	public String updateEmployee(Model model, @RequestParam("employeeId") int employeeId) {
		Employee employee = employeeService.findById(employeeId);
		model.addAttribute("employee",employee);
		return "employees/update-employee";
	}

	@GetMapping("/delete-employee")
	public String deleteEmployee(Model model, @RequestParam("employeeId")int employeeId) {
		employeeService.deleteById(employeeId);
		return "redirect:list";
	}
}









