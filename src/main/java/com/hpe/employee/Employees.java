package com.hpe.employee;

import java.util.List;

public class Employees {
    private List<Employee> employees;

    public Employees() {
        // Empty constructor - data will be set by EmployeeManager
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
