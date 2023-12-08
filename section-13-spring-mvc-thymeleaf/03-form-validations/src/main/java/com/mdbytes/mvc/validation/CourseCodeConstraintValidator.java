package com.mdbytes.mvc.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

    private String coursePrefix;

    @Override
    public void initialize(CourseCode courseCode) {
        coursePrefix = courseCode.value();

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        boolean result = false;
        if (value != null) {
            return value.startsWith(coursePrefix);
        }
        return result;
    }
}
