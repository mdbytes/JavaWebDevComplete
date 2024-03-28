package com.mdbytes.validation.model;


import com.mdbytes.validation.model.validation.CourseCode;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    private String firstName;

    @NotNull(message = "Last name is required")
    @Size(min = 1, message = "Last name is required")
    private String lastName;

    // Note: Integer class automatically trims blank spaces and parses strings
    @NotNull(message = "Free passes is required")
    @Min(value = 0, message = "Free passes must be at least 0")
    @Max(value = 10, message = "Free passes must be at most 10")
    private Integer freePasses;

    @NotNull(message = "Must be combination of 5 letters or numbers")
    @Size(min = 5, message = "Must be combination of 5 letters or numbers")
    @Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "Must be combination of 5 letters or numbers")
    private String postalCode;

    @CourseCode(value = "TOPS", message = "Must start with TOPS")
    private String courseCode;

}
