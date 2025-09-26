package com.overlook.hotel.Entity;

import jakarta.persistence.*; // JPA annotations
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
// Lombok annotations
import java.time.LocalDate;   // Date type


@Entity
@Table(name = "feedback") // Table name in the database
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Feedback {

    @Id // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id; // Use Long for large number of records

    @Column(name = "message", nullable = false, length = 1000) 
    // Feedback message, cannot be null
    private String message;

    @Column(name = "stars", nullable = false) 
    // Rating in stars (e.g., 1-5), cannot be null
    private Integer stars;

    @Column(name = "feedback_date", nullable = false) 
    // Date when feedback was submitted
    private LocalDate feedbackDate;

    @ManyToOne
    @JoinColumn(name = "Client_id", nullable = false) 
    // Many feedbacks can belong to one client
    private Client client;
}
