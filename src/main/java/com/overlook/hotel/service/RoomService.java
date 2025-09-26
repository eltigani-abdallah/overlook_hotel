// Package declaration for the service layer of the application
package com.overlook.hotel.service;

// Import Room entity class for database operations
import com.overlook.hotel.Entity.Room;
// Import RoomRepository interface for database access
import com.overlook.hotel.repository.RoomRepository;
// Import Lombok annotation to generate constructor for final fields
import lombok.RequiredArgsConstructor;
// Import Spring's Service annotation to mark this class as a service component
import org.springframework.stereotype.Service;
// Import List for returning collections of Room entities
import java.util.List;

// Service class for handling business logic related to Room entities
// This class implements CRUD (Create, Read, Update, Delete) operations
@Service
// Lombok annotation to generate constructor with required arguments (final fields)
@RequiredArgsConstructor
public class RoomService {
    // Dependency injection of RoomRepository
    // 'final' ensures the field is initialized only once via constructor
    private final RoomRepository roomRepository;

    /**
     * READ operation - Retrieves all rooms from the database
     * This corresponds to the READ part of CRUD
     * In REST API terms, this would typically be used for a GET /rooms endpoint
     * @return List of all Room entities
     */
    public List<Room> getAllRooms() {
        // Calls the findAll() method from JpaRepository to get all room records
        return roomRepository.findAll();
    }

    /**
     * READ operation - Retrieves a room by its ID
     * This corresponds to the READ part of CRUD
     * In REST API terms, this would typically be used for a GET /rooms/{id} endpoint
     * @param id The ID of the room to find
     * @return Room entity if found
     * @throws RuntimeException if room is not found
     */
    public Room getRoomById(Long id) {
        // Finds room by ID, throws exception if not found
        return roomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Room not found"));
    }

    /**
     * CREATE operation - Creates a new room in the database
     * This corresponds to the CREATE part of CRUD
     * In REST API terms, this would typically be used for a POST /rooms endpoint
     * @param room Room entity to be created
     * @return The created Room entity with generated ID
     */
    public Room createRoom(Room room) {
        // Saves the new room entity to the database
        return roomRepository.save(room);
    }

    /**
     * UPDATE operation - Updates an existing room in the database
     * This corresponds to the UPDATE part of CRUD
     * In REST API terms, this would typically be used for a PUT /rooms/{id} endpoint
     * @param id The ID of the room to update
     * @param roomDetails Room entity containing updated information
     * @return The updated Room entity
     */
    public Room updateRoom(Long id, Room roomDetails) {
        // Retrieves the existing room from the database
        Room room = getRoomById(id);

        // Updates the room's number with the new value
        //room.setNumber(roomDetails.getNumber());
        // Updates the room's type with the new value
        room.setType(roomDetails.getType());
        // Updates the room's price with the new value
        room.setPrice(roomDetails.getPrice());
        // Updates the room's availability with the new value
        //room.setAvailable(roomDetails.isAvailable());

        // Saves the updated room entity back to the database
        return roomRepository.save(room);
    }

    /**
     * DELETE operation - Deletes a room from the database
     * This corresponds to the DELETE part of CRUD
     * In REST API terms, this would typically be used for a DELETE /rooms/{id} endpoint
     * @param id The ID of the room to delete
     */
    public void deleteRoom(Long id) {
        // Deletes the room with the specified ID from the database
        roomRepository.deleteById(id);
    }
}
