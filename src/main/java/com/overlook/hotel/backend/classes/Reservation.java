package com.overlook.hotel.backend.classes;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;

@Getter @Setter
public class Reservation {
    /**
     * reservation id
     */
    private int id;

    /**
     * reservation start date
     */
    private Date reservationStart;

    /**
     * reservation end date
     */
    private Date reservationEnd;

    /**
     * number of adults
     */
    private int adultNum;

    /**
     * number of children
     */
    private int childNum;

    /**
     * ID of reservation maker
     */
    private int clientId;

    /**
     * list of IDs of reserved rooms
     */
    private ArrayList<Integer> roomIdList;

    /**
     * event id in case of events
     */
    private int eventId;


}
