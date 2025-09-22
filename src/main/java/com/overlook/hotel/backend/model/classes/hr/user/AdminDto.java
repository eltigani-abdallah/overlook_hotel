package com.overlook.hotel.backend.model.classes.hr.user;


import com.overlook.hotel.backend.model.classes.hr.employee.LeaveRequestDto;
import com.overlook.hotel.backend.model.classes.logistic.EventRoomDto;
import com.overlook.hotel.backend.model.classes.logistic.RoomDto;
import lombok.experimental.SuperBuilder;


import java.util.Date;

@SuperBuilder
public class AdminDto extends UserDto {

    public void viewAllStats(){}

    public void viewEmployeeStats(){}

    public void changeEmployeeTitle(EmployeeDto employee, String title){
        employee.setTitle(title);
    }

    public void approveEmployeeLeave(LeaveRequestDto request){
        request.setApproved(true);
    }

    public void rejectEmployeeLeave(LeaveRequestDto request){
        request.setApproved(false);
    }

    public void setEmployeeResponsible(EventRoomDto room, EmployeeDto employee){
        room.setEmployeeResponsible(employee);
    }

    public void viewRoomStats(){}

    public void replyToFeedback(RoomDto roomDto, FeedbackDto feedbackToReplyTo, int id, String message){
        Date now= new Date();
        FeedbackDto reply = FeedbackDto.builder()
                .id(id)
                .message(message)
                .commentDate(now)
                .build();
        for (FeedbackDto feedback: roomDto.getFeedbackList()){
            if (feedback == feedbackToReplyTo){
                feedback.replies.add(reply);
            }

        }
    }


}
