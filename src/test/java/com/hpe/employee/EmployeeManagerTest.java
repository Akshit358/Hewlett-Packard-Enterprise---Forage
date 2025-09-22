package com.hpe.employee;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class EmployeeManagerTest {
    
    private EmployeeManager employeeManager;
    
    @BeforeEach
    void setUp() {
        employeeManager = new EmployeeManager();
    }
    
    @Test
    void testGetEmployees() {
        Employees employees = employeeManager.getEmployees();
        assertNotNull(employees);
        assertNotNull(employees.getEmployees());
        assertEquals(4, employees.getEmployees().size());
    }
    
    @Test
    void testInitializedEmployees() {
        Employees employees = employeeManager.getEmployees();
        List<Employee> employeeList = employees.getEmployees();
        
        // Check that we have exactly 4 employees as specified
        assertEquals(4, employeeList.size());
        
        // Check first employee
        Employee emp1 = employeeList.get(0);
        assertEquals("EMP001", emp1.getEmployee_id());
        assertEquals("John", emp1.getFirst_name());
        assertEquals("Doe", emp1.getLast_name());
        assertEquals("john.doe@hpe.com", emp1.getEmail());
        assertEquals("Software Engineer", emp1.getTitle());
        
        // Check second employee
        Employee emp2 = employeeList.get(1);
        assertEquals("EMP002", emp2.getEmployee_id());
        assertEquals("Jane", emp2.getFirst_name());
        assertEquals("Smith", emp2.getLast_name());
        assertEquals("jane.smith@hpe.com", emp2.getEmail());
        assertEquals("Product Manager", emp2.getTitle());
        
        // Check third employee
        Employee emp3 = employeeList.get(2);
        assertEquals("EMP003", emp3.getEmployee_id());
        assertEquals("Mike", emp3.getFirst_name());
        assertEquals("Johnson", emp3.getLast_name());
        assertEquals("mike.johnson@hpe.com", emp3.getEmail());
        assertEquals("Data Scientist", emp3.getTitle());
        
        // Check fourth employee
        Employee emp4 = employeeList.get(3);
        assertEquals("EMP004", emp4.getEmployee_id());
        assertEquals("Sarah", emp4.getFirst_name());
        assertEquals("Williams", emp4.getLast_name());
        assertEquals("sarah.williams@hpe.com", emp4.getEmail());
        assertEquals("UX Designer", emp4.getTitle());
    }
    
    @Test
    void testAddEmployee() {
        // Get initial count
        int initialCount = employeeManager.getEmployees().getEmployees().size();
        assertEquals(4, initialCount);
        
        // Create new employee
        Employee newEmployee = new Employee("EMP005", "David", "Brown", "david.brown@hpe.com", "DevOps Engineer");
        
        // Add employee
        employeeManager.addEmployee(newEmployee);
        
        // Verify employee was added
        List<Employee> employees = employeeManager.getEmployees().getEmployees();
        assertEquals(5, employees.size());
        
        // Verify the added employee is correct
        Employee addedEmployee = employees.get(4);
        assertEquals("EMP005", addedEmployee.getEmployee_id());
        assertEquals("David", addedEmployee.getFirst_name());
        assertEquals("Brown", addedEmployee.getLast_name());
        assertEquals("david.brown@hpe.com", addedEmployee.getEmail());
        assertEquals("DevOps Engineer", addedEmployee.getTitle());
    }
    
    @Test
    void testAddMultipleEmployees() {
        // Add first employee
        Employee emp1 = new Employee("EMP005", "David", "Brown", "david.brown@hpe.com", "DevOps Engineer");
        employeeManager.addEmployee(emp1);
        
        // Add second employee
        Employee emp2 = new Employee("EMP006", "Lisa", "Garcia", "lisa.garcia@hpe.com", "QA Engineer");
        employeeManager.addEmployee(emp2);
        
        // Verify both employees were added
        List<Employee> employees = employeeManager.getEmployees().getEmployees();
        assertEquals(6, employees.size());
        
        // Verify first added employee
        Employee addedEmp1 = employees.get(4);
        assertEquals("EMP005", addedEmp1.getEmployee_id());
        assertEquals("David", addedEmp1.getFirst_name());
        
        // Verify second added employee
        Employee addedEmp2 = employees.get(5);
        assertEquals("EMP006", addedEmp2.getEmployee_id());
        assertEquals("Lisa", addedEmp2.getFirst_name());
    }
    
    @Test
    void testAddEmployeeWithNullValues() {
        Employee employeeWithNulls = new Employee();
        employeeWithNulls.setEmployee_id("EMP007");
        employeeWithNulls.setFirst_name(null);
        employeeWithNulls.setLast_name("Wilson");
        employeeWithNulls.setEmail("wilson@hpe.com");
        employeeWithNulls.setTitle("Analyst");
        
        employeeManager.addEmployee(employeeWithNulls);
        
        List<Employee> employees = employeeManager.getEmployees().getEmployees();
        assertEquals(5, employees.size());
        
        Employee addedEmployee = employees.get(4);
        assertEquals("EMP007", addedEmployee.getEmployee_id());
        assertNull(addedEmployee.getFirst_name());
        assertEquals("Wilson", addedEmployee.getLast_name());
    }
}
