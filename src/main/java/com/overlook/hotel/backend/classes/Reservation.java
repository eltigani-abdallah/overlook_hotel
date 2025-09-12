package com.overlook.hotel.backend.classes;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;

@Getter @Setter @RequiredArgsConstructor
public class Reservation {
    public Reservation(int id, Client client, int guestAmount, Date startDate, Date endDate, ArrayList<Room> roomList){
        this.id=id;
        this.client=client;
        this.guestAmount=guestAmount;
        this.startDate=startDate;
        this.endDate=endDate;
        this.eventName=eventName;
        this.roomList=roomList;
    }

    public Reservation(int id, Client client, int guestAmount, Date startDate, Date endDate, Room roomToReserve){
        this.id=id;
        this.client=client;
        this.guestAmount=guestAmount;
        this.startDate=startDate;
        this.endDate=endDate;
        this.roomToReserve=roomToReserve;

    }

    public Reservation(int id, Client client, int guestAmount, Date startDate, Date endDate, String eventName, Employee employeeResponsible, Room roomToReserve) {
        this.id=id;
        this.client=client;
        this.guestAmount=guestAmount;
        this.startDate=startDate;
        this.endDate=endDate;
        this.roomToReserve=roomToReserve;
        this.eventName=eventName;
        this.employeeResponsible=employeeResponsible;
    }


    private final int id;
    private final Client client;
    private final int guestAmount;
    private final Date startDate;
    private final Date endDate;
    private String eventName;
    private Employee employeeResponsible;
    private ArrayList<Room> roomList;
    private Room roomToReserve;



}
