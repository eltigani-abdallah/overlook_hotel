package com.overlook.hotel.backend.model.classes.dto.logistic;


import com.overlook.hotel.backend.model.classes.dto.hr.user.FeedbackDto;

import lombok.Data;
import lombok.NonNull;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;

@Data
@SuperBuilder
public class RoomDto {

    private final Long id;
    @NonNull private String type;
    private String roomNumber;
    private final Double price;
    @NonNull private String bedType;
    private final int capacity;
    private boolean isAvailable;
    public ArrayList<FeedbackDto> feedbackList = new ArrayList<FeedbackDto>();


    public void addFeedback(FeedbackDto feedback){
        this.feedbackList.add(feedback);

    }



}
