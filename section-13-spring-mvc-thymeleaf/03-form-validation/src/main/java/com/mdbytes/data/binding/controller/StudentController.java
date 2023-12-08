package com.mdbytes.data.binding.controller;

import com.mdbytes.data.binding.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    @Value("${countries}")
    private List<String> countries;

    @Value("${languages}")
    private List<String> languages;

    @Value("${systems}")
    private List<String> systems;

    @GetMapping("/student-form")
    public String showForm(Model model) {

        // create new student object
        Student student = new Student();

        // add student object to model
        model.addAttribute("student", student);

        // add countries to model
        model.addAttribute("countries", countries);

        // add languages to model
        model.addAttribute("languages", languages);

        model.addAttribute("systems", systems);

        return "student/student-form";
    }

    @PostMapping("/process-student-form")
    public String processStudentForm(@ModelAttribute("student") Student student) {

        System.out.println(student.toString());
        return "student/student-confirmation";
    }
}
