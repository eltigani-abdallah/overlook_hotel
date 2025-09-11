package com.overlook.hotel.backend.classes;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class Comment {

    /**
     * Comment ID
     */
    private int id;

    /**
     * ID of the user who left the comment
     */
    private int userId;

    /**
     * Message in the comment
     */

    private String message;

    /**
     * Number of stars given to the room
     */
    private int stars;

    /**
     * Feedback date
     */
    private Date commentDate;
}
