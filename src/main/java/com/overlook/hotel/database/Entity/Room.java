package com.overlook.hotel.database.Entity;


import jakarta.persistence.*; // JPA annotations
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
// Lombok annotations

@Entity
@Table(name = "rooms") // Define table name explicitly
@Data
@Builder// Lombok: generates getters, setters, toString(), equals(), and hashCode()
@NoArgsConstructor // Lombok: generates a no-args constructor
@AllArgsConstructor // Lombok: generates a constructor with all fields
public class Room {

    @Id // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    // Auto-increment strategy for PostgreSQL
    private Long id;

    @Column(name = "room_number", nullable = false, unique = true, length = 20) 
    // Room number must be unique and not null
    private String roomNumber;

    @Column(nullable = false) 
    // Price cannot be null
    private Double price;

    @Column(nullable = false, length = 50) 
    // Room type cannot be null
    private String type;

    @Column(name = "bed_type", nullable = false, length = 50) 
    // Bed type cannot be null
    private String bedType;

    @Column(name = "is_available", nullable = false) 
    // Availability status (true = available, false = occupied)
    private Boolean isAvailable;
}
