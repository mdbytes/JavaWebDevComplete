package com.mdbytes.thymeleaf.demo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {
    // new controller method to show the form
    @RequestMapping("/")
    public String homePage() {
        return "hello-world";
    }

    @RequestMapping("/show-form")
    public String showForm() {
        return "user/hello-world-form";
    }

    // new controller to process the form
    @GetMapping("/process-form")
    public String processForm(@RequestParam("userName") String userName, Model model) {

        model.addAttribute("userName", userName);

        return "user/hello-user";
    }

    // Display expanded form
    @GetMapping("/profile-form")
    public String shoutItOut(HttpServletRequest request, Model model) {
        return "profile/profile-form";
    }

    // Process and display form
    @GetMapping("/profile")
    public String shoutItOutProfile(HttpServletRequest request, Model model) {
        String firstName = request.getParameter("firstName");
        firstName = firstName.toUpperCase();

        String message = "YO " + firstName + "!";

        model.addAttribute("message", message);

        return "profile/profile";
    }

    // Process and display form
    @GetMapping("/profile2")
    public String shoutItOutProfileVersion2(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, Model model) {
        firstName = firstName.toUpperCase();

        String message = "YO " + firstName + " " + lastName + "!";

        model.addAttribute("message", message);

        return "profile/profile";
    }

    @PostMapping("/profile3")
    public String shoutItOutProfilePost(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, Model model) {
        firstName = firstName.toUpperCase();

        String message = "YO " + firstName + " " + lastName + "!";

        model.addAttribute("message", message);

        return "profile/profile";
    }


}
