package com.overlook.hotel.repository;

import com.overlook.hotel.Entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Repository interface for Admin entity
// Extends JpaRepository to provide CRUD operations for Admin entity with Long as the ID type
@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {}
