package com.overlook.hotel.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "loyalty") // Table name in the database
@Data                   // Lombok: generates getters, setters, equals, hashCode, toString
@NoArgsConstructor      // Lombok: generates no-args constructor
@AllArgsConstructor     // Lombok: generates all-args constructor
@Builder
public class Loyalty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    // Primary key, auto-incremented by the database
    private Integer id;

    @Column(nullable = false) 
    // Number of visits required for loyalty level, cannot be null
    private Integer visitedNumber;

    @Enumerated(EnumType.STRING) 
    @Column(nullable = false, length = 20) 
    // Loyalty status stored as a String (e.g., BRONZE, SILVER, GOLD)
    private LoyaltyStatus status;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true) 
    // One-to-one relationship with User entity, foreign key column = user_id
    private User user;
}
