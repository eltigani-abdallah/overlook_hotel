
package com.overlook.hotel.Entity;

import jakarta.persistence.*; // JPA annotations
import lombok.*;              // Lombok annotations
import java.time.LocalDateTime; // DateTime type

/**
 * This class represents the "employee_leave" table in the PostgreSQL database.
 * Each field corresponds to a column in the table.
 * Relationship:
 * - Many leave records can belong to one employee.
 */
@Entity
@Table(name = "employee_leave") // Explicit table name
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeLeave {

    @Id // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Use Long for large number of records

    @Column(name = "start_time", nullable = false)
    // Start date and time of the leave
    private LocalDateTime startTime;

    @Column(name = "end_time", nullable = false)
    // End date and time of the leave
    private LocalDateTime endTime;

    @Column(name = "status", nullable = false, length = 50)
    // Status of the leave (e.g., "Pending", "Approved", "Rejected")
    private String status;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    // Many leave records can belong to one employee
    private Employee employee;
}
