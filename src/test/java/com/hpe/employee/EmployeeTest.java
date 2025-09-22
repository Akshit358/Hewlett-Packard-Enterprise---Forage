package com.hpe.employee;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class EmployeeTest {
    
    private Employee employee;
    
    @BeforeEach
    void setUp() {
        employee = new Employee();
    }
    
    @Test
    void testDefaultConstructor() {
        Employee emp = new Employee();
        assertNotNull(emp);
        assertNull(emp.getEmployee_id());
        assertNull(emp.getFirst_name());
        assertNull(emp.getLast_name());
        assertNull(emp.getEmail());
        assertNull(emp.getTitle());
    }
    
    @Test
    void testParameterizedConstructor() {
        Employee emp = new Employee("EMP001", "John", "Doe", "john.doe@hpe.com", "Software Engineer");
        
        assertEquals("EMP001", emp.getEmployee_id());
        assertEquals("John", emp.getFirst_name());
        assertEquals("Doe", emp.getLast_name());
        assertEquals("john.doe@hpe.com", emp.getEmail());
        assertEquals("Software Engineer", emp.getTitle());
    }
    
    @Test
    void testSettersAndGetters() {
        // Test employee_id
        employee.setEmployee_id("EMP123");
        assertEquals("EMP123", employee.getEmployee_id());
        
        // Test first_name
        employee.setFirst_name("Jane");
        assertEquals("Jane", employee.getFirst_name());
        
        // Test last_name
        employee.setLast_name("Smith");
        assertEquals("Smith", employee.getLast_name());
        
        // Test email
        employee.setEmail("jane.smith@hpe.com");
        assertEquals("jane.smith@hpe.com", employee.getEmail());
        
        // Test title
        employee.setTitle("Product Manager");
        assertEquals("Product Manager", employee.getTitle());
    }
    
    @Test
    void testSetAllFields() {
        employee.setEmployee_id("EMP456");
        employee.setFirst_name("Mike");
        employee.setLast_name("Johnson");
        employee.setEmail("mike.johnson@hpe.com");
        employee.setTitle("Data Scientist");
        
        assertEquals("EMP456", employee.getEmployee_id());
        assertEquals("Mike", employee.getFirst_name());
        assertEquals("Johnson", employee.getLast_name());
        assertEquals("mike.johnson@hpe.com", employee.getEmail());
        assertEquals("Data Scientist", employee.getTitle());
    }
    
    @Test
    void testNullValues() {
        employee.setEmployee_id(null);
        employee.setFirst_name(null);
        employee.setLast_name(null);
        employee.setEmail(null);
        employee.setTitle(null);
        
        assertNull(employee.getEmployee_id());
        assertNull(employee.getFirst_name());
        assertNull(employee.getLast_name());
        assertNull(employee.getEmail());
        assertNull(employee.getTitle());
    }
}
