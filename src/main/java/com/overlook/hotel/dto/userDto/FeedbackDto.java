package com.overlook.hotel.dto.userDto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.NonNull;

import java.time.LocalDate;
import java.util.ArrayList;


/**
 * Feedback given by the client, employee or admin
 */
@Getter @Setter
@Builder
public class FeedbackDto {


    private Long id;
    @NonNull private UserDto commenter;
    @NonNull private String message;
    @NonNull private LocalDate commentDate;
    private Integer stars;
    public ArrayList<FeedbackDto> replies;
}
