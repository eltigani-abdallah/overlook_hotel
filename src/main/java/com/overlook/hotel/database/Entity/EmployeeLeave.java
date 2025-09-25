package com.overlook.hotel.database.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import com.overlook.hotel.database.Entity.Employee;

/**
 * EmployeeLeave entity mapped to the "employee_leave" table.
 * Represents leave requests for either an Employee or an Admin.
 */
@Entity
@Table(name = "employee_leave")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeLeave {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incremented ID
    private Long id;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate; // Leave start date

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate; // Leave end date

    @Column(nullable = false, length = 50)
    private String status; // Leave status (e.g., Approved, Pending, Rejected)

    // Leave may belong to an employee
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    // Or leave may belong to an admin
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
            throw new IllegalStateException("EmployeeLeave must belong to exactly one owner: either employee or admin");
        }
    }
}
