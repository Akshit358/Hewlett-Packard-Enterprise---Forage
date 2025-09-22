# Hewlett Packard Enterprise - Employee Service

A Spring Boot RESTful web service for managing employee data, built as part of the HPE Forage program.

## Overview

This service provides a REST API endpoint to retrieve employee information in JSON format. It's built using Java Spring Boot and follows RESTful principles.

## Features

- **GET /employees** - Retrieve all employees
- Hardcoded employee data (4 sample employees)
- JSON response format as specified in requirements
- Spring Boot embedded Tomcat server on port 8080

## Project Structure

```
src/main/java/com/hpe/employee/
├── Employee.java              # Employee entity with private fields and getters
├── Employees.java             # Manager class for employee list
├── EmployeeManager.java       # Initializes and manages employee data
├── EmployeeController.java    # REST controller with /employees endpoint
└── RestServiceApplication.java  # Main Spring Boot application class

src/main/resources/
└── application.properties     # Application configuration

pom.xml                       # Maven dependencies and build configuration
```

## API Endpoints

### GET /employees

Returns a JSON array of all employees.

**Request:**
```http
GET http://localhost:8080/employees
```

**Response:**
```json
{
    "employees": [
        {
            "employee_id": "EMP001",
            "first_name": "John",
            "last_name": "Doe",
            "email": "john.doe@hpe.com",
            "title": "Software Engineer"
        },
        {
            "employee_id": "EMP002",
            "first_name": "Jane",
            "last_name": "Smith",
            "email": "jane.smith@hpe.com",
            "title": "Product Manager"
        },
        {
            "employee_id": "EMP003",
            "first_name": "Mike",
            "last_name": "Johnson",
            "email": "mike.johnson@hpe.com",
            "title": "Data Scientist"
        },
        {
            "employee_id": "EMP004",
            "first_name": "Sarah",
            "last_name": "Williams",
            "email": "sarah.williams@hpe.com",
            "title": "UX Designer"
        }
    ]
}
```

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven 3.6 or higher

### Running the Application

1. Clone the repository:
```bash
git clone https://github.com/Akshit358/Hewlett-Packard-Enterprise---Forage.git
cd Hewlett-Packard-Enterprise---Forage
```

2. Build the project:
```bash
mvn clean compile
```

3. Run the application:
```bash
mvn spring-boot:run
```

4. The service will be available at `http://localhost:8080`

### Testing the API

You can test the API using curl:

```bash
curl -X GET http://localhost:8080/employees
```

Or using any HTTP client like Postman, Insomnia, etc.

## Technologies Used

- **Java 17**
- **Spring Boot 3.2.0**
- **Maven** (Build tool)
- **Spring Web** (REST API framework)
- **Embedded Tomcat** (Web server)

## Requirements Fulfilled

✅ Employee class with private variables and getter functions  
✅ Employees class that manages the full list of employees  
✅ EmployeeManager class responsible for initializing employee data  
✅ Controller class with GET /employees endpoint  
✅ Hardcoded employee data (4 employees as specified)  
✅ JSON response format matching specifications  
✅ Spring Boot RESTful web service architecture  

## Task 2 Completion

This project fulfills all requirements for Task 2 of the HPE Forage program:

- Created a Spring Boot RESTful web service
- Implemented GET /employees endpoint
- Returns JSON representation of employee data
- Includes all required components (Employee, Employees, EmployeeManager, EmployeeController, RestServiceApplication classes)
- Hardcoded employee data as specified (4 employees)
- Service runs on localhost:8080 as required

## Core Application Files

The following files contain the core application logic as specified in the task requirements:

- `Employee.java` - Employee resource class with private variables and getters
- `Employees.java` - Resource class that maintains employee list
- `EmployeeManager.java` - Class responsible for initializing employee data
- `EmployeeController.java` - Resource controller for HTTP GET requests
- `RestServiceApplication.java` - Main Spring Boot application class
