package com.overlook.hotel.backend.classes;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Employee {
    /**
     * employee ID
     */
    private int id;

    /**
     * employee age
     */
    private int age;

    /**
     * employee gender <br>
     * to help you discriminate against your employees
     */
    private String gender;

    /**
     * employee job role
     */

    private String role;

    /**
     * employee first name <br>
     * you'll forget it in 2 seconds anyway
     */
    private String firstName;

    /**
     * employee last name
     */
    private String lastName;

    /**
     * employee email
     */
    private String email;

    /**
     * password hash for the employee
     */
    private String passwordHash;

    /**
     * employee home address
     */
    private String address;

    /**
     * employee phone number
     */
    private String phoneNumber;

    /**
     * employee status
     */
    private String status;



}
