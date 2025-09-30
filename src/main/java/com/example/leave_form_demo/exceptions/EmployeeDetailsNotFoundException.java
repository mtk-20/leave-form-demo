package com.example.leave_form_demo.exceptions;

public class EmployeeDetailsNotFoundException extends RuntimeException {

    public EmployeeDetailsNotFoundException(Long id) {
        super("EmployeeDetails not found with id: " + id);
    }
}
