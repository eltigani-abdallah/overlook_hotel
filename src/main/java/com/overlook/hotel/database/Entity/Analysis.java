package com.overlook.hotel.database.Entity;

import jakarta.persistence.*; // JPA annotations
import lombok.*;              // Lombok annotations

/**
 * This class represents the "analysis" table in the PostgreSQL database.
 * Each field corresponds to a column in the table.
 * This table stores analysis metrics such as occupied rooms and financial performance.
 */
@Entity
@Table(name = "analysis") // Explicit table name
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Analysis {

    @Id // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Use Long for large number of records

    @Column(name = "feedback_id", nullable = false)
    // Reference to feedback (could be a foreign key in future)
    private Integer feedbackId;

    @Column(name = "occupied_rooms", nullable = false)
    // Number of occupied rooms (can be fractional for analysis)
    private Double occupiedRooms;

    @Column(name = "financial_performance", nullable = false)
    // Financial performance metric
    private Double financialPerformance;
}
