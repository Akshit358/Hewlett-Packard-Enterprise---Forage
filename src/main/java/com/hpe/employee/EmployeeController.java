package com.hpe.employee;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    
    private final EmployeeManager employeeManager;

    public EmployeeController() {
        this.employeeManager = new EmployeeManager();
    }

    @GetMapping("/employees")
    public Employees getAllEmployees() {
        return employeeManager.getEmployees();
    }
}
