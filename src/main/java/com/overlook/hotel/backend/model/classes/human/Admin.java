package com.overlook.hotel.backend.model.classes.human;


import com.overlook.hotel.backend.model.classes.logistic.Room;
import lombok.experimental.SuperBuilder;


import java.util.Date;

@SuperBuilder
public class Admin extends User {

    public void viewAllStats(){}

    public void viewEmployeeStats(){}

    public void approveEmployeeLeave(){}

    public void rejectEmployeeLeave(){}


    public void viewRoomStats(){}

    public void replyToFeedback(Room room, Feedback feedbackToReplyTo, int id, String message){
        Date now= new Date();
        Feedback reply = Feedback.builder()
                .id(id)
                .message(message)
                .commentDate(now)
                .build();
        for (Feedback feedback: room.getFeedbackList()){
            if (feedback == feedbackToReplyTo){
                feedback.replies.add(reply);
            }

        }
    }
}
