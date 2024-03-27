package com.example.Custom.Validator.Validation;

import java.util.Arrays;
import java.util.List;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/*  This particular class always implements ConstraintValidator class and inside that we write the class for which we have written this logic 
and next we write for which type of field are we gonna write this logic abput */
public class EmployeeTypeValidator implements ConstraintValidator<ValidateEmployeeType, String> {
    /* Then we just need to override this method isValid() */
    @Override
    public boolean isValid(String employeeType, ConstraintValidatorContext constraintValidatorContext) {
        List<String> employeeTypes = Arrays.asList("Permanent", "vendor");
        return employeeTypes.contains(employeeType);
    }
}
