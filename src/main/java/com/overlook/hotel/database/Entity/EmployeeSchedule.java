
package com.overlook.hotel.database.Entity;

import jakarta.persistence.*; // JPA annotations
import lombok.*;              // Lombok annotations
import java.time.LocalDate;   // Date type
import java.time.LocalTime;   // Time type


@Entity
@Table(name = "employee_schedule") // Explicit table name
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeSchedule {

    @Id // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Use Long for large number of records

    @Column(name = "work_schedule", nullable = false)
    // Date of the work schedule
    private LocalDate workSchedule;

    @Column(name = "start_time", nullable = false)
    // Start time of the shift
    private LocalTime startTime;

    @Column(name = "end_time", nullable = false)
    // End time of the shift
    private LocalTime endTime;

    @Column(name = "status", nullable = false, length = 50)
    // Status of the schedule (e.g., "Scheduled", "Completed")
    private String status;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    // Many schedules can belong to one employee
    private Employee employee;
}
