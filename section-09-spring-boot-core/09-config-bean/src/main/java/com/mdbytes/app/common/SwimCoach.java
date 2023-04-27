package com.mdbytes.app.common;

// Not using @Component notation (on purpose)

public class SwimCoach implements Coach {
    public SwimCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Swim a warm up of 1000 meters";
    }
}
