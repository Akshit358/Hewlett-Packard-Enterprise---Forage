package com.hpe.employee;

import java.util.ArrayList;
import java.util.List;

public class Employees {
    private List<Employee> employees;

    public Employees() {
        this.employees = new ArrayList<>();
        initializeEmployees();
    }

    private void initializeEmployees() {
        // Hardcoded employee data as specified in the requirements
        employees.add(new Employee("EMP001", "John", "Doe", "john.doe@hpe.com", "Software Engineer"));
        employees.add(new Employee("EMP002", "Jane", "Smith", "jane.smith@hpe.com", "Product Manager"));
        employees.add(new Employee("EMP003", "Mike", "Johnson", "mike.johnson@hpe.com", "Data Scientist"));
        employees.add(new Employee("EMP004", "Sarah", "Williams", "sarah.williams@hpe.com", "UX Designer"));
        employees.add(new Employee("EMP005", "David", "Brown", "david.brown@hpe.com", "DevOps Engineer"));
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
