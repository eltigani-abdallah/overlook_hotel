package com.overlook.hotel.backend;


import lombok.Getter;
import lombok.Setter;

/**
 * @brief clients of the hotel
 */
@Getter @Setter
public class Client {


    /**
     * ID to be taken from the database
     */
    private int id;

    /**
     * client age
     */
    private int age;

    /**
     * client gender
     */
    private String gender;

    /**
     * client first name
     */
     private String firstName;

    /**
     * client last name
     */
    private String lastName;

    /**
     * client email
     */
    private String email;

    /**
     * password hash for the client
     */
    private String passwordHash;

    /**
     * client home address
     */
    private String address;

    /**
     * client phone number
     */
    private String phoneNumber;

    /**
     * points awarded to loyal customers.<br>
     * need to think about how to award said points<br>
     * economy I guess
     */
    private int loyaltyPoints;


}
