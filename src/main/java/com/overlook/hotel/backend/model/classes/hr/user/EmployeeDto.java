package com.overlook.hotel.backend.model.classes.hr.user;

import com.overlook.hotel.backend.model.classes.hr.employee.LeaveRequestDto;
import com.overlook.hotel.backend.model.classes.logistic.ReservationDto;
import com.overlook.hotel.backend.model.classes.logistic.RoomDto;
import static com.overlook.hotel.backend.model.classes.tools.Util.stringToDate;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import java.util.Date;



@Getter @Setter @SuperBuilder
public class EmployeeDto extends UserDto {


    private String presence;
    private String title;



    @Override
    public void modifyReservation(ReservationDto reservationDto, ReservationDto.FieldToModify field, String value){
        switch (field) {
            case GUESTAMOUNT ->
                reservationDto.setGuestAmount(Integer.parseInt(value));
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

    public LeaveRequestDto requestLeave(int id, Date startDate, Date endDate, String reason){
        return LeaveRequestDto.builder()
            .id(id)
            .requestMaker(this)
            .startDate(startDate)
            .endDate(endDate)
            .reason(reason)
            .build();
    }




}
