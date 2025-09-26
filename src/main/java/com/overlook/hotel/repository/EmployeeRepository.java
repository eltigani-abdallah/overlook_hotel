package com.overlook.hotel.repository;

import com.overlook.hotel.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Repository interface for Employee entity
// Extends JpaRepository to provide CRUD operations for Employee entity with Long as the ID type
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {}
