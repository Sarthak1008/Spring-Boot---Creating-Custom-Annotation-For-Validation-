package com.example.Custom.Validator.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Custom.Validator.Entities.Employee;
import com.example.Custom.Validator.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    /*
     * @ Valid marks a property, method parameter or method return type for
     * validation cascading.Constraints defined on the object and its
     * properties are validated when the property, method parameter or method return
     * type is validated.
     */

    @PostMapping
    public Employee addNewEmployeeToSystem(@RequestBody @Valid Employee employee) {
        return service.addNewEmployee(employee);
    }
}
