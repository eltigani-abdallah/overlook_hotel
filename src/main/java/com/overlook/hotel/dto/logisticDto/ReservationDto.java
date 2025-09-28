package com.overlook.hotel.dto.logisticDto;



import com.overlook.hotel.dto.userDto.ClientDto;
import com.overlook.hotel.dto.userDto.EmployeeDto;
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
    private int adultAmount;
    private int childAmount;
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
