package com.hpe.employee;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class EmployeeControllerTest {
    
    private EmployeeController employeeController;
    
    @BeforeEach
    void setUp() {
        employeeController = new EmployeeController();
    }
    
    @Test
    void testGetAllEmployees() {
        // Test the actual controller behavior
        Employees result = employeeController.getAllEmployees();
        
        assertNotNull(result);
        assertNotNull(result.getEmployees());
        assertEquals(4, result.getEmployees().size());
        
        // Verify the structure of the response
        List<Employee> employees = result.getEmployees();
        assertFalse(employees.isEmpty());
        
        // Check that all employees have required fields
        for (Employee emp : employees) {
            assertNotNull(emp.getEmployee_id());
            assertNotNull(emp.getFirst_name());
            assertNotNull(emp.getLast_name());
            assertNotNull(emp.getEmail());
            assertNotNull(emp.getTitle());
        }
    }
    
    @Test
    void testGetAllEmployeesReturnsCorrectData() {
        Employees result = employeeController.getAllEmployees();
        List<Employee> employees = result.getEmployees();
        
        // Verify we have the expected initial employees
        assertEquals(4, employees.size());
        
        // Check specific employees exist
        boolean foundJohn = employees.stream()
            .anyMatch(emp -> "John".equals(emp.getFirst_name()) && "Doe".equals(emp.getLast_name()));
        assertTrue(foundJohn, "John Doe should be in the employee list");
        
        boolean foundJane = employees.stream()
            .anyMatch(emp -> "Jane".equals(emp.getFirst_name()) && "Smith".equals(emp.getLast_name()));
        assertTrue(foundJane, "Jane Smith should be in the employee list");
    }
    
    @Test
    void testAddEmployee() {
        // Create a new employee to add
        Employee newEmployee = new Employee("EMP005", "David", "Brown", "david.brown@hpe.com", "DevOps Engineer");
        
        // Test adding the employee
        Employee result = employeeController.addEmployee(newEmployee);
        
        // Verify the returned employee matches what we sent
        assertNotNull(result);
        assertEquals("EMP005", result.getEmployee_id());
        assertEquals("David", result.getFirst_name());
        assertEquals("Brown", result.getLast_name());
        assertEquals("david.brown@hpe.com", result.getEmail());
        assertEquals("DevOps Engineer", result.getTitle());
    }
    
    @Test
    void testAddEmployeeAndVerifyInList() {
        // Get initial count
        Employees initialEmployees = employeeController.getAllEmployees();
        int initialCount = initialEmployees.getEmployees().size();
        assertEquals(4, initialCount);
        
        // Add new employee
        Employee newEmployee = new Employee("EMP005", "David", "Brown", "david.brown@hpe.com", "DevOps Engineer");
        employeeController.addEmployee(newEmployee);
        
        // Verify employee was added to the list
        Employees updatedEmployees = employeeController.getAllEmployees();
        assertEquals(5, updatedEmployees.getEmployees().size());
        
        // Verify the new employee is in the list
        boolean foundNewEmployee = updatedEmployees.getEmployees().stream()
            .anyMatch(emp -> "EMP005".equals(emp.getEmployee_id()));
        assertTrue(foundNewEmployee, "New employee should be in the list");
    }
    
    @Test
    void testAddMultipleEmployees() {
        // Add first employee
        Employee emp1 = new Employee("EMP005", "David", "Brown", "david.brown@hpe.com", "DevOps Engineer");
        employeeController.addEmployee(emp1);
        
        // Add second employee
        Employee emp2 = new Employee("EMP006", "Lisa", "Garcia", "lisa.garcia@hpe.com", "QA Engineer");
        employeeController.addEmployee(emp2);
        
        // Verify both employees were added
        Employees employees = employeeController.getAllEmployees();
        assertEquals(6, employees.getEmployees().size());
        
        // Verify both employees are in the list
        List<Employee> employeeList = employees.getEmployees();
        boolean foundEmp5 = employeeList.stream()
            .anyMatch(emp -> "EMP005".equals(emp.getEmployee_id()));
        boolean foundEmp6 = employeeList.stream()
            .anyMatch(emp -> "EMP006".equals(emp.getEmployee_id()));
        
        assertTrue(foundEmp5, "Employee EMP005 should be in the list");
        assertTrue(foundEmp6, "Employee EMP006 should be in the list");
    }
    
    @Test
    void testAddEmployeeWithNullValues() {
        Employee employeeWithNulls = new Employee();
        employeeWithNulls.setEmployee_id("EMP007");
        employeeWithNulls.setFirst_name(null);
        employeeWithNulls.setLast_name("Wilson");
        employeeWithNulls.setEmail("wilson@hpe.com");
        employeeWithNulls.setTitle("Analyst");
        
        Employee result = employeeController.addEmployee(employeeWithNulls);
        
        assertNotNull(result);
        assertEquals("EMP007", result.getEmployee_id());
        assertNull(result.getFirst_name());
        assertEquals("Wilson", result.getLast_name());
        assertEquals("wilson@hpe.com", result.getEmail());
        assertEquals("Analyst", result.getTitle());
    }
    
    @Test
    void testAddEmployeeWithEmptyStrings() {
        Employee employeeWithEmptyStrings = new Employee();
        employeeWithEmptyStrings.setEmployee_id("");
        employeeWithEmptyStrings.setFirst_name("");
        employeeWithEmptyStrings.setLast_name("");
        employeeWithEmptyStrings.setEmail("");
        employeeWithEmptyStrings.setTitle("");
        
        Employee result = employeeController.addEmployee(employeeWithEmptyStrings);
        
        assertNotNull(result);
        assertEquals("", result.getEmployee_id());
        assertEquals("", result.getFirst_name());
        assertEquals("", result.getLast_name());
        assertEquals("", result.getEmail());
        assertEquals("", result.getTitle());
    }
    
    @Test
    void testControllerIsolation() {
        // Test that each controller instance is independent
        EmployeeController controller1 = new EmployeeController();
        EmployeeController controller2 = new EmployeeController();
        
        // Add employee to first controller
        Employee emp1 = new Employee("CTRL001", "Controller", "One", "ctrl1@hpe.com", "Tester");
        controller1.addEmployee(emp1);
        
        // Verify it's in first controller
        assertEquals(5, controller1.getAllEmployees().getEmployees().size());
        
        // Verify it's NOT in second controller (they should be independent)
        assertEquals(4, controller2.getAllEmployees().getEmployees().size());
    }
}
