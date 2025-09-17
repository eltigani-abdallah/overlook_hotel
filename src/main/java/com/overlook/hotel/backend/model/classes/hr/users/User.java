package com.overlook.hotel.backend.model.classes.hr.users;


import com.overlook.hotel.backend.model.classes.logistic.Reservation;
import com.overlook.hotel.backend.model.classes.logistic.Room;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.Date;

@Setter @Getter @SuperBuilder
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
        System.err.println("Wrong function motherf*****");
        return null;
    }

    public Reservation reserveEvent(int id, Client client, int guestAmount, Date startDate, Date endDate, String eventName, Employee employeeResponsible, ArrayList<Room> roomList){
        System.err.println("Wrong  event function motherf*****");
        return null;
    }
    public void cancelReservation(Reservation reservation){
    }

    public void modifyReservation(Reservation reservation){}

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
     * @param stars
     * @param message
     * @param commentDate
     */
    public void giveFeedback(Room roomToRate, int id, String message, Date commentDate, int stars){
        Feedback feedback = Feedback.builder()
                .id(id)
                .commenter(this)
                .message(message)
                .commentDate(commentDate)
                .stars(stars)
                .build();
        roomToRate.addFeedback(feedback);
    }


}
