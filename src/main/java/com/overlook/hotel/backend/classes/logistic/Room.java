package com.overlook.hotel.backend.classes.logistic;

import com.overlook.hotel.backend.classes.human.Feedback;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter @Setter
public class Room {
    private int id;
    private String name;
    private int capacity;
    private boolean isReserved;
    private String type;
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
