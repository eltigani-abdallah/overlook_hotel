package com.overlook.hotel.backend.classes;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class Event {

    /**
     * Event ID
     */
    private int id;

    /**
     * Event name
     */
    private String eventName;

    /**
     * Event description
     */
    private String eventDescription;

    /**
     * Event date
     */
    private Date eventDate;

    /**
     * Reservation ID
     */
    private int reservationId;

    /**
     * Responsable employee ID
     */
    private int employeeId;
}
