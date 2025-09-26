package com.overlook.hotel.repository;

import com.overlook.hotel.Entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Repository interface for Event entity
// Extends JpaRepository to provide CRUD operations for Event entity with Long as the ID type
@Repository
public interface EventRepository extends JpaRepository<Event, Long> {}
