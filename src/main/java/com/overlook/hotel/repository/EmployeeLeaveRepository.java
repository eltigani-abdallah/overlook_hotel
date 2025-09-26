

// Package declaration for the repository layer of the application
package com.overlook.hotel.repository;

// Import all entity classes from the database.Entity package

import com.overlook.hotel.Entity.*;

// Import JpaRepository interface from Spring Data JPA for database operations
import org.springframework.data.jpa.repository.JpaRepository;

// Import Repository annotation to indicate that the interface is a Spring Data Repository
import org.springframework.stereotype.Repository;


// Repository interface for EmployeeLeave entity
// Extends JpaRepository to provide CRUD operations for EmployeeLeave entity with Long as the ID type
@Repository
public interface EmployeeLeaveRepository extends JpaRepository<EmployeeLeave, Long> {}
