package com.overlook.hotel.controller;

import com.overlook.hotel.database.Entity.Employee; // Import Employee entity
import com.overlook.hotel.service.EmployeeService; // Import service
import lombok.RequiredArgsConstructor; // Constructor injection with Lombok
import org.springframework.web.bind.annotation.*; // REST annotations

import java.util.List; // For returning lists

@RestController // Marks this class as REST controller
@RequestMapping("/api/employees") // Base URL for employee API
@RequiredArgsConstructor // Lombok: generates constructor for final fields
public class EmployeeController {

    private final EmployeeService employeeService; // Service dependency

    // GET /api/employees -> fetch all employees
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    // GET /api/employees/{id} -> fetch employee by ID
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    // POST /api/employees -> create new employee
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    // PUT /api/employees/{id} -> update existing employee
    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        return employeeService.updateEmployee(id, employee);
    }

    // DELETE /api/employees/{id} -> delete employee by ID
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }
}
