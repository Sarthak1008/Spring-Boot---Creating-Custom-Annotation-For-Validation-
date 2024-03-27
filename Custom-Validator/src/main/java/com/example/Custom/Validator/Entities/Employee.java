package com.example.Custom.Validator.Entities;

import java.util.Date;

import com.example.Custom.Validator.Validation.ValidateEmployeeType;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private int empId;

    // @NotBlank annotation is given by springboot validate dependency by default
    // and is used to validate that the given field is not left blank while
    // initializing data
    @NotBlank(message = "firstName shouldn't be null or empty")
    private String firstName;
    @NotBlank(message = "lastName shouldn't be null or empty")
    private String lastName;
    /*
     * The annotated element must be an instant, date or time in the past. Now is
     * defined by the ClockProvider attached to the Validator or ValidatorFactory.
     * The default clockProvider defines the current time according to the virtual
     * machine, applying the current default time zone if needed
     */
    @Past(message = "start shouldn't be before current date")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date doj;
    // @NotNull and NotEmpty annotation is given by springboot validate dependency
    // and both of checks combinally makes @NotBlank
    @NotNull(message = "department shouldn't be null")
    @NotEmpty(message = "department shouldn't be empty")
    private String dept;

    // @Email annotation is given by springboot validate dependency by default and
    // is used to validate the format of email i.e @email.com
    @Email(message = "invalid email id")
    private String email;
    // Until now we can pass any value in employeeType but lets say we just want it
    // to be
    @ValidateEmployeeType
    private String employeeType; // permanent or vendor or contractual

    // So in this kinda case when we want users to pass allowed field then you
    // create your custom validators or own annotation to validate that field
}
