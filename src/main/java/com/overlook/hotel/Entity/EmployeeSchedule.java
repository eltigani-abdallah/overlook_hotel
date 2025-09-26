package com.overlook.hotel.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

import com.overlook.hotel.Entity.Employee;

/**
 * EmployeeSchedule entity mapped to the "employee_schedule" table.
 * Represents a work schedule for either an Employee or an Admin.
 */
@Entity
@Table(name = "employee_schedule")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incremented ID
    private Long id;

    @Column(name = "work_schedule", nullable = false)
    private LocalDate workSchedule; // Date of the schedule

    @Column(name = "start_time", nullable = false)
    private LocalTime startTime; // Shift start time

    @Column(name = "end_time", nullable = false)
    private LocalTime endTime; // Shift end time

    @Column(nullable = false, length = 50)
    private String status; // Schedule status (e.g., Scheduled, Completed)

    // A schedule may belong to an employee
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    // Or a schedule may belong to an admin
    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;

    /**
     * Validation before persisting/updating:
     * Ensure that exactly one owner is defined (either employee or admin).
     */
    @PrePersist
    @PreUpdate
    private void validateOwner() {
        if ((employee == null && admin == null) || (employee != null && admin != null)) {
            throw new IllegalStateException("EmployeeSchedule must belong to exactly one owner: either employee or admin");
        }
    }
}
