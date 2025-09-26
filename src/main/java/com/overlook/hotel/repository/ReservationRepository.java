package com.overlook.hotel.repository;

import com.overlook.hotel.Entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Repository interface for Reservation entity
// Extends JpaRepository to provide CRUD operations for Reservation entity with Long as the ID type
@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {}
