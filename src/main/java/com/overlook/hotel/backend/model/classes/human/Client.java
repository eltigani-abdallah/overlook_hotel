package com.overlook.hotel.backend.model.classes.human;


import com.overlook.hotel.backend.model.classes.logistic.Reservation;
import com.overlook.hotel.backend.model.classes.logistic.Room;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;

/**
 * @brief clients of the hotel
 */
@Getter @Setter
public class Client extends User {

    public Client(int id, Date birthDate, String gender, String firstName, String lastName, String passwordHash, String email, String address, String phoneNumber){
        super(id, birthDate, gender, firstName, lastName, passwordHash, email, address, phoneNumber);
    }

    /**
     * points awarded to loyal customers.<br>
     * need to think about how to award said points<br>
     * economy I guess
     */
    private int loyaltyPoints;

    /**
     * reservation history
     */
    private ArrayList<Reservation> reservationHistory;

    public Reservation reserveRoom(int id, int guestAmount, Date startDate, Date endDate, ArrayList<Room> roomList){
        ArrayList<Room> validReservations= new ArrayList<Room>();
        if (startDate.after(endDate)){
            System.err.println("Start date must be before the end date");
            /// do something here for reservation failure
        }
        for (Room room: roomList){
            if (guestAmount>room.getCapacity()){
                System.out.println(room.getName()+" cannot be reserved; guests exceed capacity");
                continue;
            }
            validReservations.add(room);
        }
        Reservation newReservation= new Reservation(id, this, guestAmount, startDate, endDate, validReservations);
        this.reservationHistory.add(newReservation);
        return newReservation;
    }


    public void modifyReservation(Reservation reservation){

    }




}
