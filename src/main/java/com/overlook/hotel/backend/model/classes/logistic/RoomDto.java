package com.overlook.hotel.backend.model.classes.logistic;


import com.overlook.hotel.backend.model.classes.hr.user.FeedbackDto;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;

@Getter @Setter @SuperBuilder
public class RoomDto {

    private final Long id;
    @NonNull private String type;
    @NonNull private String name;
    private String roomNumber;
    private final Double price;
    @NonNull private String bedType;
    private final int capacity;
    private boolean isAvailable;
    public ArrayList<FeedbackDto> feedbackList = new ArrayList<FeedbackDto>();


    public void vacate(){
        if (isAvailable){
            isAvailable =false;
        }
    }

    public void addFeedback(FeedbackDto feedback){
        this.feedbackList.add(feedback);

    }



}
