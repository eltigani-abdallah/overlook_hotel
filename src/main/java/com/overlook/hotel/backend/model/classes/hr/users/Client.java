package com.overlook.hotel.backend.model.classes.hr.users;


import com.overlook.hotel.backend.model.classes.logistic.Reservation;
import com.overlook.hotel.backend.model.classes.logistic.Room;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.Date;

/**
 * @brief clients of the hotel
 */
@Getter @Setter @SuperBuilder
public class Client extends User {

    /**
     * points awarded to loyal customers.<br>
     * need to think about how to award said points<br>
     * economy I guess
     */
    private int loyaltyPoints;

    /**
     * reservation history
     */
    @Builder.Default
    private ArrayList<Reservation> reservationHistory = new ArrayList<Reservation>();

    @Override
    public Reservation reserveRoom(int id, int guestAmount, Date startDate, Date endDate, ArrayList<Room> roomList){
        ArrayList<Room> validReservations= new ArrayList<Room>();
        if (startDate.after(endDate)){
            System.err.println("Start date must be before the end date");
            return null;
            /// do something here for reservation failure
        }
        for (Room room: roomList){
            if (guestAmount>room.getCapacity()){
                System.out.println(room.getName()+" cannot be reserved; guests exceed capacity");
                continue;
            }
            validReservations.add(room);
        }
        Reservation newReservation= Reservation.builder()
                .id(id)
                .customer(this)
                .guestAmount(guestAmount)
                .startDate(startDate)
                .endDate(endDate)
                .roomList(validReservations)
                .build();
        this.reservationHistory.add(newReservation);
        return newReservation;
    }

    @Override
    public void modifyReservation(Reservation reservation){

    }




}
