package com.overlook.hotel.backend.classes.logistic;


import com.overlook.hotel.backend.classes.human.Employee;
import com.overlook.hotel.backend.classes.human.User;
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
     * @param customer
     * @param guestAmount
     * @param startDate
     * @param endDate
     * @param roomList
     */
    public Reservation(int id, User customer, int guestAmount, Date startDate, Date endDate, String eventName, Employee employeeResponsible, ArrayList<Room> roomList){
        this.id=id;
        this.customer=customer;
        this.guestAmount=guestAmount;
        this.startDate=startDate;
        this.endDate=endDate;
        this.eventName=eventName;
        this.roomList=roomList;
        this.employeeResponsible=employeeResponsible;
    }




    private final int id;
    private final User customer;
    private final int guestAmount;
    private final Date startDate;
    private final Date endDate;
    private String eventName;
    private Employee employeeResponsible;
    @NonNull
    private ArrayList<Room> roomList;




}
