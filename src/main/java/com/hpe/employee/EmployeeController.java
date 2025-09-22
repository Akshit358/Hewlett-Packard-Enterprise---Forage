package com.hpe.employee;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    
    private final Employees employees;

    public EmployeeController() {
        this.employees = new Employees();
    }

    @GetMapping("/employees")
    public Employees getAllEmployees() {
        return employees;
    }
}
