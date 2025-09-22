package com.hpe.employee;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
public class EmployeeServiceIntegrationTest {
    
    @Test
    void contextLoads() {
        // This test ensures that the Spring Boot application context loads successfully
        // If this test passes, it means all our beans are properly configured
        assertTrue(true, "Application context should load successfully");
    }
    
    @Test
    void testEmployeeServiceComponents() {
        // Test that we can create instances of our main components
        Employee employee = new Employee("TEST001", "Test", "User", "test@hpe.com", "Tester");
        assertNotNull(employee);
        
        EmployeeManager manager = new EmployeeManager();
        assertNotNull(manager);
        
        EmployeeController controller = new EmployeeController();
        assertNotNull(controller);
        
        Employees employees = new Employees();
        assertNotNull(employees);
    }
    
    @Test
    void testEndToEndWorkflow() {
        // Test the complete workflow from controller to manager
        EmployeeController controller = new EmployeeController();
        
        // Get initial employees
        Employees initialEmployees = controller.getAllEmployees();
        int initialCount = initialEmployees.getEmployees().size();
        assertEquals(4, initialCount);
        
        // Add a new employee
        Employee newEmployee = new Employee("INT001", "Integration", "Test", "integration@hpe.com", "Integration Tester");
        Employee addedEmployee = controller.addEmployee(newEmployee);
        
        // Verify the employee was added correctly
        assertNotNull(addedEmployee);
        assertEquals("INT001", addedEmployee.getEmployee_id());
        assertEquals("Integration", addedEmployee.getFirst_name());
        assertEquals("Test", addedEmployee.getLast_name());
        assertEquals("integration@hpe.com", addedEmployee.getEmail());
        assertEquals("Integration Tester", addedEmployee.getTitle());
        
        // Verify the employee appears in the list
        Employees updatedEmployees = controller.getAllEmployees();
        assertEquals(initialCount + 1, updatedEmployees.getEmployees().size());
        
        // Verify the specific employee is in the list
        boolean foundEmployee = updatedEmployees.getEmployees().stream()
            .anyMatch(emp -> "INT001".equals(emp.getEmployee_id()));
        assertTrue(foundEmployee, "Added employee should be in the list");
    }
}
