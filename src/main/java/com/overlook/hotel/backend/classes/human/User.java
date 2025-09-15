package com.overlook.hotel.backend.classes.human;


import com.overlook.hotel.backend.classes.logistic.Reservation;
import com.overlook.hotel.backend.classes.logistic.Room;
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
     * @param guestAmount
     * @param startDate
     * @param endDate
     * @param roomList
     * @return
     */
    public Reservation reserveRoom(int id, int guestAmount, Date startDate, Date endDate, ArrayList<Room> roomList){
        return new Reservation(id, this, guestAmount, startDate, endDate, roomList);
    }

    public Reservation reserveEvent(int id, int guestAmount, Date startDate, Date endDate, String eventName, Employee employeeResponsible, ArrayList<Room> roomList){
        return new Reservation(id, this, guestAmount, startDate, endDate, eventName, employeeResponsible, roomList);
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

    /**
     * create a feedback object and add it to the feedback list of the room specified
     * @param roomToRate
     * @param id
     * @param commenter
     * @param stars
     * @param message
     * @param commentDate
     */
    public void giveFeedback(Room roomToRate, int id, User commenter, int stars, String message, Date commentDate){
        Feedback feedback = new Feedback(id, commenter, stars, message, commentDate);
        roomToRate.addFeedback(feedback);
    }
}
