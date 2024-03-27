package com.example.Custom.Validator.service;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.example.Custom.Validator.Entities.Employee;

@Service
public class EmployeeService {

    public Employee addNewEmployee(Employee employee) {
        employee.setEmpId(new Random().nextInt(68736432));
        // add employee to database
        return employee;
    }
}
