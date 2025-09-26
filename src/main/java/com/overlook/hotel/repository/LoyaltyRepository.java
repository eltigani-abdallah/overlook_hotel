package com.overlook.hotel.repository;

import com.overlook.hotel.Entity.Loyalty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Repository interface for Loyalty entity
// Extends JpaRepository to provide CRUD operations for Loyalty entity with Long as the ID type
@Repository
public interface LoyaltyRepository extends JpaRepository<Loyalty, Long> {}
