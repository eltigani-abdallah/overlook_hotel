package com.overlook.hotel.repository;

import com.overlook.hotel.Entity.EmployeeLeave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeLeaveRepository extends JpaRepository<EmployeeLeave, Long> {
    // Basic CRUD is already inherited
}
