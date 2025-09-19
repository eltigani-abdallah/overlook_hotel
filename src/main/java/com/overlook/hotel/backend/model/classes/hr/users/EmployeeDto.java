package com.overlook.hotel.backend.model.classes.hr.users;

import com.overlook.hotel.backend.model.classes.logistic.ReservationDto;
import com.overlook.hotel.backend.model.classes.logistic.RoomDto;
import com.overlook.hotel.backend.model.classes.hr.LeaveRequestDto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import java.util.Date;

@Getter @Setter @SuperBuilder
public class EmployeeDto extends UserDto {


    private String presence;
    private String title;



    @Override
    public void modifyReservation(ReservationDto reservationDto){
        System.err.println("function modifyReservation in Employee is no implemented yet");
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
