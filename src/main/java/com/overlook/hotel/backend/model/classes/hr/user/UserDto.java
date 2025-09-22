package com.overlook.hotel.backend.model.classes.hr.user;


import com.overlook.hotel.backend.model.classes.logistic.ReservationDto;
import com.overlook.hotel.backend.model.classes.logistic.RoomDto;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.Date;

@Setter @Getter @SuperBuilder
public class UserDto {
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
     * enum of possible user types
     * @items:
     * CLIENT <br>
     * EMPLOYEE <br>
     * ADMIN <br>
     */
    public enum userType{
        CLIENT,
        EMPLOYEE,
        ADMIN
    }


    /**
     * Create a reservation for multiple rooms

     */
    public ReservationDto reserveRoom(int id, int guestAmount, Date startDate, Date endDate,
                                      ArrayList<RoomDto> roomDtoList){
        System.err.println("Wrong function motherf*****");
        return null;
    }

    public ReservationDto reserveEvent(int id, ClientDto client, int guestAmount,
                                       Date startDate, Date endDate,
                                       String eventName, EmployeeDto employeeResponsible, ArrayList<RoomDto> roomDtoList){
        System.err.println("Wrong  event function motherf*****");
        return null;
    }
    public void cancelReservation(ReservationDto reservationDto){
    }


    public void modifyReservation(ReservationDto reservationDto,  ReservationDto.FieldToModify field, String value){}

    public ArrayList<ReservationDto> viewHistory(){
        return null;
    }
    public ArrayList<RoomDto> viewRooms(){
        return null;
    }

    /**
     * create a feedback object and add it to the feedback list of the room specified
     */
    public void giveFeedback(RoomDto roomDtoToRate, int id, String message,
                             Date commentDate, int stars){
        FeedbackDto feedback = FeedbackDto.builder()
                .id(id)
                .commenter(this)
                .message(message)
                .commentDate(commentDate)
                .stars(stars)
                .build();
        roomDtoToRate.addFeedback(feedback);
    }


}
