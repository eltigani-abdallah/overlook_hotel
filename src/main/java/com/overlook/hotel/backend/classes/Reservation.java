package com.overlook.hotel.backend.classes;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;

@Getter @Setter @RequiredArgsConstructor
public class Reservation {
    /**
     * @brief reserve an event
     * @param id
     * @param client
     * @param guestAmount
     * @param startDate
     * @param endDate
     * @param roomList
     */
    public Reservation(int id, Client client, int guestAmount, Date startDate, Date endDate,String eventName, Employee employeeResponsible, ArrayList<Room> roomList){
        this.id=id;
        this.client=client;
        this.guestAmount=guestAmount;
        this.startDate=startDate;
        this.endDate=endDate;
        this.eventName=eventName;
        this.roomList=roomList;
    }




    private final int id;
    private final Client client;
    private final int guestAmount;
    private final Date startDate;
    private final Date endDate;
    private String eventName;
    private Employee employeeResponsible;
    @NonNull
    private ArrayList<Room> roomList;




}
