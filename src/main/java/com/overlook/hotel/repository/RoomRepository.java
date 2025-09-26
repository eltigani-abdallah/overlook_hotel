package com.overlook.hotel.repository;

import com.overlook.hotel.Entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Repository interface for Room entity
// Extends JpaRepository to provide CRUD operations for Room entity with Long as the ID type
@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {}
