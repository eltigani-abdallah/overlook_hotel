package com.overlook.hotel.backend.classes.logistic;

import com.overlook.hotel.backend.classes.human.Feedback;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter @Setter @RequiredArgsConstructor
public class Room {

    private final int id;
    @NonNull private String type;
    @NonNull private String name;
    private final int capacity;
    private boolean isReserved;
    private ArrayList<Feedback> feedbackList;


    public void vacate(){
        if (isReserved){
            isReserved=false;
        }
    }

    public void addFeedback(Feedback feedback){
        this.feedbackList.add(feedback);

    }



}
