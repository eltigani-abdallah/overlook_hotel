package com.overlook.hotel.database.Entity;

import jakarta.persistence.*; // JPA annotations
import lombok.*;              // Lombok annotations

/**
 * This class represents the "employee" table in the PostgreSQL database.
 * Each field corresponds to a column in the table.
 */
@Entity
@Table(name = "employee") // Explicit table name
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Use Long for large number of records

    @Column(name = "first_name", nullable = false, length = 100)
    // Employee's first name
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 100)
    // Employee's last name
    private String lastName;

    @Column(nullable = false, unique = true, length = 150)
    // Employee's email, must be unique
    private String email;

    @Column(nullable = false, length = 255)
    // Employee's password
    private String password;

    @Column(length = 255)
    // Employee's address (optional)
    private String address;

    @Column(name = "phone_number", length = 20)
    // Employee's phone number (optional)
    private String phoneNumber;

    @Column(nullable = false, length = 50)
    // Employee's role (e.g., "Admin", "Receptionist")
    private String role;
}
