package com.overlook.hotel.dto.userDto;


import com.overlook.hotel.dto.logisticDto.EventRoomDto;
import com.overlook.hotel.dto.logisticDto.RoomDto;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


import java.time.LocalDate;


@SuperBuilder @Setter @Getter
public class AdminDto extends UserDto {

    private String role;

    public void viewAllStats(){}

    public void viewEmployeeStats(){}

    public void changeEmployeeTitle(EmployeeDto employee, String title){
        employee.setTitle(title);
    }

    public void approveEmployeeLeave(LeaveRequestDto request){
        request.setStatus("Approved");
    }

    public void rejectEmployeeLeave(LeaveRequestDto request){
        request.setStatus("Rejected");
    }

    public void setEmployeeResponsible(EventRoomDto room, EmployeeDto employee){
        room.setEmployeeResponsible(employee);
    }

    public void viewRoomStats(){}

    public void replyToFeedback(RoomDto roomDto, FeedbackDto feedbackToReplyTo, Long id, String message){
        FeedbackDto reply = FeedbackDto.builder()
                .id(id)
                .message(message)
                .commentDate(LocalDate.now())
                .build();
        for (FeedbackDto feedback: roomDto.getFeedbackList()){
            if (feedback == feedbackToReplyTo){
                feedback.replies.add(reply);
            }

        }
    }


}
