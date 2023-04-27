package com.mdbytes.springboot.demo.app01.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    // inject properties for coach name and team name

    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    // expose new endpoint for team info

    @GetMapping("/teaminfo")
    public String getTeamInfo() {
        return "Coach: " + coachName + " Team: " + teamName;
    }

    // expose / end point to return "Hello World"
    @GetMapping("/")
    public String sayHello() {
        return "Hello New World!!!";
    }

    // expose a new end point for "workout"
    @GetMapping("/workout")
    public String getDailyWorkout() {
        return "Run a hard 5k";
    }

    // expose new end point for "fortune"
    @GetMapping("/fortune")
    public String getFortune() {
        return "Today is your lucky day!";
    }
}
