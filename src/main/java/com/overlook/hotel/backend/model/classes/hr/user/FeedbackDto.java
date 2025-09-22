package com.overlook.hotel.backend.model.classes.hr.user;

import lombok.*;

import java.util.ArrayList;
import java.util.Date;

/**
 * Feedback given by the client, employee or admin
 */
@Getter @Setter @Builder
public class FeedbackDto {


    private final int id;
    private final int reservationId;
    @NonNull private UserDto commenter;
    @NonNull private String message;
    @NonNull private Date commentDate;
    private int stars;
    public ArrayList<FeedbackDto> replies;
}
