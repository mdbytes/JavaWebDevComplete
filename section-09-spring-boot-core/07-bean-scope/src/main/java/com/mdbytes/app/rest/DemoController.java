package com.mdbytes.app.rest;

import com.mdbytes.app.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    // define private field for dependency
    private Coach myCoach;

    private Coach assistantCoach;

    @Autowired
    public DemoController(@Qualifier("cricketCoach") Coach myCoach, @Qualifier("cricketCoach") Coach anotherCoach) {
        System.out.println("In constructor: " + getClass().getSimpleName());
        this.myCoach = myCoach;
        this.assistantCoach = anotherCoach;
    }


    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }

    @GetMapping("/check")
    public String check() {
        return "Comparing beans: myCoach == assistant coach ?  " + (myCoach == assistantCoach);
    }
}
