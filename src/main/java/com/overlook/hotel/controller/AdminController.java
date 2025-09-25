// Package declaration for the controller layer of the application
package com.overlook.hotel.controller;

import com.overlook.hotel.database.Entity.Admin;
// Import AdminService to delegate business logic
import com.overlook.hotel.service.AdminService;
// Import Lombok annotation to generate constructor for final fields
import lombok.RequiredArgsConstructor;
// Import Spring Web annotations for building RESTful controllers
import org.springframework.web.bind.annotation.*;
// Import List for returning collections of Admin entities
import java.util.List;

// Declares this class as a REST controller to handle HTTP requests
@RestController
// Maps all endpoints in this controller to "/api/admins" base path
@RequestMapping("/api/admins")
// Lombok annotation to generate constructor with required arguments (final fields)
@RequiredArgsConstructor
public class AdminController {
    // Dependency injection of AdminService
    // 'final' ensures the field is initialized only once via constructor
    private final AdminService adminService;

    /**
     * Handles GET request to retrieve all admins
     * Endpoint: GET /api/admins
     * @return List of all Admin entities
     */
    @GetMapping
    public List<Admin> getAllAdmins() {
        // Delegates to AdminService to get all admins and returns the result
        return adminService.getAllAdmins();
    }

    /**
     * Handles GET request to retrieve a specific admin by ID
     * Endpoint: GET /api/admins/{id}
     * @param id The ID of the admin to retrieve (extracted from URL path)
     * @return Admin entity with the specified ID
     */
    @GetMapping("/{id}")
    public Admin getAdminById(@PathVariable Long id) {
        // Delegates to AdminService to get admin by ID and returns the result
        return adminService.getAdminById(id);
    }

    /**
     * Handles POST request to create a new admin
     * Endpoint: POST /api/admins
     * @param admin Admin entity to be created (extracted from request body)
     * @return The created Admin entity with generated ID
     */
    @PostMapping
    public Admin createAdmin(@RequestBody Admin admin) {
        // Delegates to AdminService to create admin and returns the result
        return adminService.createAdmin(admin);
    }

    /**
     * Handles PUT request to update an existing admin
     * Endpoint: PUT /api/admins/{id}
     * @param id The ID of the admin to update (extracted from URL path)
     * @param admin Admin entity containing updated information (extracted from request body)
     * @return The updated Admin entity
     */
    @PutMapping("/{id}")
    public Admin updateAdmin(@PathVariable Long id, @RequestBody Admin admin) {
        // Delegates to AdminService to update admin and returns the result
        return adminService.updateAdmin(id, admin);
    }

    /**
     * Handles DELETE request to remove an admin
     * Endpoint: DELETE /api/admins/{id}
     * @param id The ID of the admin to delete (extracted from URL path)
     */
    @DeleteMapping("/{id}")
    public void deleteAdmin(@PathVariable Long id) {
        // Delegates to AdminService to delete admin by ID
        adminService.deleteAdmin(id);
    }
}
