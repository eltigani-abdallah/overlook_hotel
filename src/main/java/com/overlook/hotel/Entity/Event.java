package com.overlook.hotel.Entity;

import jakarta.persistence.*; // JPA annotations
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;   // Date type


@Entity
@Table(name = "event") // Explicit table name
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Event {

    @Id // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Use Long for large number of records

    @Column(name = "event_name", nullable = false, length = 255) 
    // Name of the event, cannot be null
    private String eventName;

    @Column(name = "event_description", length = 1000) 
    // Description of the event, optional
    private String eventDescription;

    @Column(name = "event_date", nullable = false) 
    // Date of the event
    private LocalDate eventDate;
}
