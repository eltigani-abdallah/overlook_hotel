package com.overlook.hotel.service;

import com.overlook.hotel.database.Entity.Employee;
import com.overlook.hotel.repository.EmployeeRepository; // Import Employee repository
import lombok.RequiredArgsConstructor; // Lombok annotation for constructor injection
import org.springframework.stereotype.Service; // Marks class as Spring service

import java.util.List; // For returning lists

@Service // Marks this class as service layer
@RequiredArgsConstructor // Lombok generates constructor with required args
public class EmployeeService {

    private final EmployeeRepository employeeRepository; // Inject repository

    // Fetch all employees
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Fetch single employee by ID
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    // Create new employee
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // Update existing employee
    public Employee updateEmployee(Long id, Employee employeeDetails) {
        // Find existing employee
        Employee employee = getEmployeeById(id);

        // Update fields
        employee.setFirstName(employeeDetails.getFirstName());
        employee.setLastName(employeeDetails.getLastName());
        employee.setEmail(employeeDetails.getEmail());
        employee.setPassword(employeeDetails.getPassword());
        employee.setPhoneNumber(employeeDetails.getPhoneNumber());
        employee.setAddress(employeeDetails.getAddress());
        employee.setRole(employeeDetails.getRole());
        

        // Save updated employee
        return employeeRepository.save(employee);
    }

    // Delete employee by ID
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
