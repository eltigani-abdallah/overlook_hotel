package com.overlook.hotel.backend.classes;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;

/**
 * @brief clients of the hotel
 */
@Getter @Setter
public class Client extends User{

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

    public Reservation reserveRoom(int id, Client client, int guestAmount, Date startDate, Date endDate, ArrayList<Room> roomList){
        Reservation newReservation= new Reservation(id, client, guestAmount, startDate, endDate, roomList);
        this.reservationHistory.add(newReservation);
        return newReservation;
    }

    public void cancelReservation(Reservation reservation){

    }

    public void modifyReservation(Reservation reservation){

    }




}
