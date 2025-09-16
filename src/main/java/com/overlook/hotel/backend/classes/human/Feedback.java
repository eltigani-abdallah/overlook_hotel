package com.overlook.hotel.backend.classes.human;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;

@Getter @Setter @RequiredArgsConstructor
/**
 * Feedback given by the client, employee or admin
 */
public class Feedback {
    public Feedback(int id, User commenter, String message, Date commentDate, int stars){
        this.id=id;
        this.commenter=commenter;
        this.message=message;
        this.commentDate=commentDate;
        this.stars=stars;
    }

    private final int id;
    @NonNull private User commenter;
    @NonNull private String message;
    @NonNull private Date commentDate;
    private int stars;
    public ArrayList<Feedback> replies;
}
