package com.overlook.hotel.backend.model.classes.logistic;


import com.overlook.hotel.backend.model.classes.human.Client;
import com.overlook.hotel.backend.model.classes.human.Employee;
import com.overlook.hotel.backend.model.classes.human.User;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;

@Getter @Setter @Builder
public class Reservation {


    private final int id;
    private Client customer;
    private int guestAmount;
    private Date startDate;
    private Date endDate;
    private String eventName;
    private Employee employeeResponsible;
    private ArrayList<Room> roomList;




}
