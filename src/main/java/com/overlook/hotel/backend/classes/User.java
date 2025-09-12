package com.overlook.hotel.backend.classes;


import lombok.*;

import java.util.ArrayList;
import java.util.Date;

@Setter @Getter @RequiredArgsConstructor @NoArgsConstructor(force = true)
public class User {
    private final int id;
    @NonNull
    private Date birthDate;
    @NonNull
    private String gender;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private String passwordHash;
    @NonNull
    private String email;
    @NonNull
    private String address;
    @NonNull
    private String phoneNumber;


    /**
     * Create a reservation for multiple rooms
     * @param id
     * @param client
     * @param guestAmount
     * @param startDate
     * @param endDate
     * @param roomList
     * @return
     */
    public Reservation reserveRoom(int id, Client client, int guestAmount, Date startDate, Date endDate, ArrayList<Room> roomList){
        return new Reservation(id, client, guestAmount, startDate, endDate, roomList);
    }
    public Reservation reserveSingleRoom(int id, Client client, int guestAmount, Date startDate, Date endDate, Room room){
        return new Reservation(id, client, guestAmount, startDate, endDate, room);
    }
    public Reservation reserveEvent(int id, Client client, int guestAmount, Date startDate, Date endDate, String eventName, Employee employeeResponsible, Room room){
        return new Reservation(id, client, guestAmount, startDate, endDate, eventName, employeeResponsible, room);
    }
    public void cancelReservation(Room room){
    }
    public void modifyReservation(Room room){}

    public ArrayList<Reservation> viewHistory(){
        return null;
    }
    public ArrayList<Room> viewRooms(){
        return null;
    }
}
