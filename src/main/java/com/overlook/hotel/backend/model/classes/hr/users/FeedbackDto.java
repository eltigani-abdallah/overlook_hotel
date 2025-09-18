package com.overlook.hotel.backend.model.classes.hr.users;

import lombok.*;

import java.util.ArrayList;
import java.util.Date;

/**
 * Feedback given by the client, employee or admin
 */
@Getter @Setter @Builder
public class FeedbackDto {


    private final int id;
    @NonNull private UserDto commenter;
    @NonNull private String message;
    @NonNull private Date commentDate;
    @NonNull private int reservationId;
    private int stars;
    public ArrayList<FeedbackDto> replies;
}
