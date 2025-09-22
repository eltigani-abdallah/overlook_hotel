package com.overlook.hotel.backend.model.classes.logistic;


import com.overlook.hotel.backend.model.classes.hr.user.ClientDto;
import com.overlook.hotel.backend.model.classes.hr.user.EmployeeDto;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;

@Getter @Setter @Builder
public class ReservationDto {


    private final int id;
    @NonNull private ClientDto customer;
    @NonNull private int guestAmount;
    @NonNull private Date startDate;
    @NonNull private Date endDate;
    @NonNull private String eventName;
    private boolean isApproved;
    private EmployeeDto employeeResponsible;
    private ArrayList<RoomDto> roomDtoList;

    public enum FieldToModify{
        GUESTAMOUNT,
        STARTDATE,
        ENDDATE,
        EVENTNAME,

    }




}
