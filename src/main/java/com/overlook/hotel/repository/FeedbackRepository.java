package com.overlook.hotel.repository;

import com.overlook.hotel.Entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Repository interface for Feedback entity
// Extends JpaRepository to provide CRUD operations for Feedback entity with Long as the ID type
@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {}
