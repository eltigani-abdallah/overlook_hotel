package com.overlook.hotel.repository;

import com.overlook.hotel.database.Entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    // CRUD methods are inherited from JpaRepository (save, findAll, findById, deleteById, etc.)
}
