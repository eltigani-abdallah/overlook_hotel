package com.overlook.hotel.backend.model.classes.logistic;


import com.overlook.hotel.backend.model.classes.hr.users.FeedbackDto;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter @Setter @RequiredArgsConstructor
public class RoomDto {

    private final int id;
    @NonNull private String type;
    @NonNull private String name;
    private final int capacity;
    private boolean isReserved;
    public ArrayList<FeedbackDto> feedbackList = new ArrayList<FeedbackDto>();


    public void vacate(){
        if (isReserved){
            isReserved=false;
        }
    }

    public void addFeedback(FeedbackDto feedback){
        this.feedbackList.add(feedback);

    }



}
