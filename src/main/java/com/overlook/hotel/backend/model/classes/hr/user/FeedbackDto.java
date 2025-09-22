package com.overlook.hotel.backend.model.classes.hr.user;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.NonNull;

import java.time.LocalDate;
import java.util.ArrayList;


/**
 * Feedback given by the client, employee or admin
 */
@Getter @Setter
@Builder
public class FeedbackDto {


    private final int id;
    private final int reservationId;
    @NonNull private UserDto commenter;
    @NonNull private String message;
    @NonNull private LocalDate commentDate;
    private int stars;
    public ArrayList<FeedbackDto> replies;
}
