package com.overlook.hotel.backend.classes.human;


import com.overlook.hotel.backend.classes.logistic.Room;


import java.util.Date;

public class Admin extends User {
    public Admin(int id, Date birthDate, String gender, String firstName, String lastName, String passwordHash, String email, String address, String phoneNumber){
        super(id, birthDate, gender, firstName, lastName, passwordHash, email, address, phoneNumber);
    }

    public void viewAllStats(){}

    public void viewEmployeeStats(){}

    public void approveEmployeeLeave(){}

    public void rejectEmployeeLeave(){}


    public void viewRoomStats(){}

    public void replyToFeedback(Room room, Feedback feedbackToReplyTo, int id, String message){
        Date now= new Date();
        Feedback reply = new Feedback(id, this, message, now);
        for (Feedback feedback: room.getFeedbackList()){
            if (feedback == feedbackToReplyTo){
                feedback.replies.add(reply);
            }

        }
    }
}
