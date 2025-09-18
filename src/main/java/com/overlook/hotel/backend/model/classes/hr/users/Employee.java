package com.overlook.hotel.backend.model.classes.hr.users;

import com.overlook.hotel.backend.model.classes.logistic.Reservation;
import com.overlook.hotel.backend.model.classes.logistic.Room;
import com.overlook.hotel.backend.model.classes.hr.LeaveRequest;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Getter @Setter @SuperBuilder
public class Employee extends User {


    private String presence;
    private String title;




    public void modifyReservation(Reservation reservation){
        System.err.println("function modifyReservation in Employee is no implemented yet");
    }

    @Override
    public void cancelReservation(Reservation reservation){
        for(Room room: reservation.getRoomList())
            if(room.isReserved()){
                room.setReserved(false);
        }
    }

    public LeaveRequest requestLeave(int id, Date startDate, Date endDate, String reason){
        return LeaveRequest.builder()
            .id(id)
            .startDate(startDate)
            .endDate(endDate)
            .reason(reason)
            .build();
    }




}
