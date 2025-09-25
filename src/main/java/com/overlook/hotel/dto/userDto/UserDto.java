package com.overlook.hotel.dto.userDto;


import com.overlook.hotel.dto.logisticDto.ReservationDto;
import com.overlook.hotel.dto.logisticDto.RoomDto;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


import java.time.LocalDate;
import java.util.ArrayList;


@Setter
@Getter
@SuperBuilder
public class UserDto {
    private final Long id;
    @NonNull
    private Integer age;
    @NonNull
    private String gender;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private String password;
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
    public enum UserType {
        CLIENT,
        EMPLOYEE,
        ADMIN
    }


    public ArrayList<ReservationDto> viewHistory(){
        return null;
    }
    public ArrayList<RoomDto> viewRooms(){
        return null;
    }

    /**
     * create a feedback object and add it to the feedback list of the room specified
     */
    public void giveFeedback(RoomDto roomDtoToRate, Long id, String message, int stars){
        FeedbackDto feedback = FeedbackDto.builder()
                .id(id)
                .commenter(this)
                .message(message)
                .commentDate(LocalDate.now())
                .stars(stars)
                .build();
        roomDtoToRate.addFeedback(feedback);
    }


}
