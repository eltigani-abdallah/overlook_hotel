package com.overlook.hotel.backend.model.classes.logistic;


import com.overlook.hotel.backend.model.classes.hr.users.ClientDto;
import com.overlook.hotel.backend.model.classes.hr.users.EmployeeDto;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;

@Getter @Setter @Builder
public class ReservationDto {


    private final int id;
    private ClientDto customer;
    private int guestAmount;
    private Date startDate;
    private Date endDate;
    private String eventName;
    private EmployeeDto employeeResponsible;
    private ArrayList<RoomDto> roomDtoList;




}
