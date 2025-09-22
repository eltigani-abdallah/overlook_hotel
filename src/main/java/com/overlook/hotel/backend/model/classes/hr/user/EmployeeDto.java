package com.overlook.hotel.backend.model.classes.hr.user;

import com.overlook.hotel.backend.model.classes.hr.employee.LeaveRequestDto;
import com.overlook.hotel.backend.model.classes.logistic.ReservationDto;
import com.overlook.hotel.backend.model.classes.logistic.RoomDto;
import static com.overlook.hotel.backend.model.classes.tools.Util.stringToDate;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;




@Getter @Setter @SuperBuilder
public class EmployeeDto extends UserDto {


    private String presence;
    private String title;
    private String role;



    @Override
    public void modifyReservation(ReservationDto reservationDto, ReservationDto.FieldToModify field, String value){
        switch (field) {
            case ADULTAMOUNT ->
                reservationDto.setAdultAmount(Integer.parseInt(value));
            case CHILDAMOUNT ->
                reservationDto.setChildAmount(Integer.parseInt(value));
            case STARTDATE ->
                reservationDto.setStartDate(stringToDate(value));
            case ENDDATE ->
                reservationDto.setEndDate(stringToDate(value));
            case EVENTNAME ->
                reservationDto.setEventName(value);
        }
    }

    @Override
    public void cancelReservation(ReservationDto reservationDto){
        for(RoomDto roomDto : reservationDto.getRoomDtoList())
            if(roomDto.isReserved()){
                roomDto.setReserved(false);
        }
    }

    public LeaveRequestDto requestLeave(int id, LocalDate startDate, LocalDate endDate, String reason){
        return LeaveRequestDto.builder()
            .id(id)
            .requestMaker(this)
            .startDate(startDate)
            .endDate(endDate)
            .reason(reason)
            .build();
    }




}
