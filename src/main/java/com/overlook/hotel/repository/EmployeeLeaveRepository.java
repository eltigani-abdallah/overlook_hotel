package com.overlook.hotel.repository;

// Import all entity classes from the database.Entity package

import com.overlook.hotel.Entity.*;

// Import JpaRepository interface from Spring Data JPA for database operations
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeLeaveRepository extends JpaRepository<EmployeeLeave, Long> {
    // Basic CRUD is already inherited
}
