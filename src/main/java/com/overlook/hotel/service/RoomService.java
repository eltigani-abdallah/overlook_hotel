package com.overlook.hotel.service;

import com.overlook.hotel.Entity.Room;
import com.overlook.hotel.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;

    // READ all rooms
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    // READ by ID
    public Room getRoomById(Long id) {
        return roomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Room not found"));
    }

    // CREATE
    public Room createRoom(Room room) {
        return roomRepository.save(room);
    }

    // UPDATE
    public Room updateRoom(Long id, Room roomDetails) {
        Room room = getRoomById(id);

        room.setRoomNumber(roomDetails.getRoomNumber());   
        room.setType(roomDetails.getType());              
        room.setPrice(roomDetails.getPrice());          
        room.setBedType(roomDetails.getBedType());        
        room.setIsAvailable(roomDetails.getIsAvailable()); 

        return roomRepository.save(room);
    }

    // DELETE
    public void deleteRoom(Long id) {
        roomRepository.deleteById(id);
    }
}
