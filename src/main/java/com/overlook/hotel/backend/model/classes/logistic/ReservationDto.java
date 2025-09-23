package com.overlook.hotel.backend.model.classes.logistic;


import com.overlook.hotel.backend.model.classes.hr.user.ClientDto;
import com.overlook.hotel.backend.model.classes.hr.user.EmployeeDto;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDate;



@Data
@Builder
public class ReservationDto {


    private final Long id;
    @NonNull
    private ClientDto customer;
    @NonNull private int adultAmount;
    @NonNull private int childAmount;
    @NonNull private LocalDate startDate;
    @NonNull private LocalDate endDate;
    private String eventName;
    private boolean isApproved;
    private EmployeeDto employeeResponsible;
    private RoomDto roomToReserve;
    private EventDto event;

    public enum FieldToModify{
        ADULTAMOUNT,
        CHILDAMOUNT,
        STARTDATE,
        ENDDATE,
        EVENTNAME,

    }




}
