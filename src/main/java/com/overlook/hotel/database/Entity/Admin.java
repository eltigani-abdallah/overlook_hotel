package com.overlook.hotel.database.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

/**
 * Admin entity mapped to the "admin" table.
 * Represents administrators who can also have schedules and leaves.
 */
@Entity
@Table(name = "admin")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incremented ID
    private Long id;

    @Column(nullable = false) 
    // Column "age" cannot be NULL
    private Integer age;

    @Column(nullable = false, length = 10) 
    // "gender" cannot be NULL, maximum 10 characters
    private String gender;

    @Column(nullable = false, length = 100)
    private String firstName;

    @Column(nullable = false, length = 100)
    private String lastName;

    @Column(nullable = false, unique = true, length = 150)
    private String email;

    @Column(nullable = false, length = 255)
    private String password;

    @Column(length = 255)
    private String address;


    @Column(nullable = false, unique = true,length = 20)
    private String phoneNumber;

    @Column(nullable = false, length = 50)
    private String role;

    // One admin can have many schedules
    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<com.overlook.hotel.database.Entity.EmployeeSchedule> schedules;

    // One admin can have many leaves
    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<com.overlook.hotel.database.Entity.EmployeeLeave> leaves;
}
