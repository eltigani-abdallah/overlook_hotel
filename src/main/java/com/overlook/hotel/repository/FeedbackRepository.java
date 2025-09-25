
package com.overlook.hotel.repository;

import com.overlook.hotel.database.Entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    // Inherits CRUD operations: save, findAll, findById, deleteById
}
