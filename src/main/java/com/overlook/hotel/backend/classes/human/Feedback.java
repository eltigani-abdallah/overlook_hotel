package com.overlook.hotel.backend.classes.human;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter @Setter @RequiredArgsConstructor
/**
 * Feedback given by the client, employee or admin
 */
public class Feedback {

    private final int id;
    @NonNull private User commenter;
    private final int stars;
    @NonNull private String message;
    @NonNull private Date commentDate;
}
