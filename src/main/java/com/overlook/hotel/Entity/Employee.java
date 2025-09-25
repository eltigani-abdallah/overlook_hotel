package com.overlook.hotel.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Employee entity mapped to the "employee" table.
 * Represents hotel staff employees.
 */
@Entity
@Table(name = "employee")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {

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

    @Column(length = 20)
    private String phoneNumber;

    @Column(nullable = false, length = 50)
    private String role;

    // One employee can have many schedules
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EmployeeSchedule> schedules;

    // One employee can have many leaves
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EmployeeLeave> leaves;
}
