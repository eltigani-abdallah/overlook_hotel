
package com.overlook.hotel.Entity;



import jakarta.persistence.*; // JPA annotations
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;
// Lombok annotations

@Entity
@Table(name = "Client") // Define the table name in the database
@Data // Lombok: generates getters, setters, toString(), equals(), and hashCode()
@NoArgsConstructor // Lombok: generates a no-args constructor
@AllArgsConstructor // Lombok: generates a constructor with all fields
@Builder
public class Client {

    @Id // Marks this field as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    // Auto-increment strategy (Postgres will automatically generate IDs)
    private Long id;

    @Column(nullable = false) 
    // Column "age" cannot be NULL
    private Integer age;

    @Column(nullable = false, length = 10) 
    // "gender" cannot be NULL, maximum 10 characters
    private String gender;

    @Column(name = "first_name", nullable = false, length = 100) 
    // Explicitly define column name as "first_name" instead of "firstName"
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 100) 
    private String lastName;

    @Column(name  = "email", unique = true, length = 150)
    // "email" must be unique and cannot be NULL
    private String email;

    @Column(nullable = false, length = 255) 
    // "password" cannot be NULL
    private String password;

    @Column(length = 255) 
    // "address" can be NULL, but max length is 255
    private String address;

    @Column(name = "phone_number", length = 20) 
    // Explicitly define column name "phone_number"
    private String phoneNumber;

    @Column(length = 500) 
    // "note" is optional, maximum length 500
    private String note;
}
