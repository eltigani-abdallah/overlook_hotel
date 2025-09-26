package com.overlook.hotel.controller;

import com.overlook.hotel.Entity.Room;
import com.overlook.hotel.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;

    // REST API: GET /api/rooms  -> returns all rooms
    @GetMapping
    public List<Room> getAllRooms() {
        return roomService.getAllRooms(); // CRUD call
    }

    // REST API: GET /api/rooms/{id} -> returns one room
    @GetMapping("/{id}")
    public Room getRoomById(@PathVariable Long id) {
        return roomService.getRoomById(id); // CRUD call
    }

    // REST API: POST /api/rooms -> create new room
    @PostMapping
    public Room createRoom(@RequestBody Room room) {
        return roomService.createRoom(room); // CRUD call
    }

    // REST API: PUT /api/rooms/{id} -> update room
    @PutMapping("/{id}")
    public Room updateRoom(@PathVariable Long id, @RequestBody Room room) {
        return roomService.updateRoom(id, room); // CRUD call
    }

    // REST API: DELETE /api/rooms/{id} -> delete room
    @DeleteMapping("/{id}")
    public void deleteRoom(@PathVariable Long id) {
        roomService.deleteRoom(id); // CRUD call
    }
}
