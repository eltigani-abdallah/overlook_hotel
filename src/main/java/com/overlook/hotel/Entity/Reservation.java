package com.overlook.hotel.Entity;


import jakarta.persistence.*; // JPA annotations
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
// Lombok annotations
import java.time.LocalDate;

@Entity
@Table(name = "reservation") // Table name in the database
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reservation {

    @Id // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Use Long for large number of records

    @Column(name = "reservation_date_start", nullable = false)
    // Start date of the reservation (cannot be null)
    private LocalDate reservationDateStart;

    @Column(name = "reservation_date_end", nullable = false)
    // End date of the reservation (cannot be null)
    private LocalDate reservationDateEnd;

    @Column(name = "adult_number", nullable = false)
    // Number of adults for the reservation
    private Integer adultNumber;

    @Column(name = "children_number", nullable = false)
    // Number of children for the reservation
    private Integer childrenNumber;

    @ManyToOne
    @JoinColumn(name = "Client_id", nullable = false)
    // Many reservations can belong to one client
    private Client client;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    // Many reservations can be for one room
    private Room room;

    @ManyToOne
    @JoinColumn(name = "event_id")
    // Optional: reservation may be linked to an event
    private Event event;
}
