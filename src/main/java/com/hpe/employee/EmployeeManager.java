package com.hpe.employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeManager {
    private Employees employees;

    public EmployeeManager() {
        this.employees = new Employees();
        initializeEmployees();
    }

    private void initializeEmployees() {
        // Hardcoded 3-4 example employees as specified in requirements
        List<Employee> employeeList = new ArrayList<>();
        
        employeeList.add(new Employee("EMP001", "John", "Doe", "john.doe@hpe.com", "Software Engineer"));
        employeeList.add(new Employee("EMP002", "Jane", "Smith", "jane.smith@hpe.com", "Product Manager"));
        employeeList.add(new Employee("EMP003", "Mike", "Johnson", "mike.johnson@hpe.com", "Data Scientist"));
        employeeList.add(new Employee("EMP004", "Sarah", "Williams", "sarah.williams@hpe.com", "UX Designer"));
        
        employees.setEmployees(employeeList);
    }

    public Employees getEmployees() {
        return employees;
    }
}
