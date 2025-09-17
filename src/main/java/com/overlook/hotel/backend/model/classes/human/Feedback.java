package com.overlook.hotel.backend.model.classes.human;

import lombok.*;

import java.util.ArrayList;
import java.util.Date;

/**
 * Feedback given by the client, employee or admin
 */
@Getter @Setter @Builder
public class Feedback {


    private final int id;
    @NonNull private User commenter;
    @NonNull private String message;
    @NonNull private Date commentDate;
    @NonNull private int reservationId;
    private int stars;
    public ArrayList<Feedback> replies;
}
