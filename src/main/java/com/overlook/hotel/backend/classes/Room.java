package com.overlook.hotel.backend.classes;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Room {
    /**
     * Room ID
     */
    private int id;

    /**
     * Room number
     */
    private int roomNumber;

    /**
     * price per night
     */
    private double price;

    /**
     * type of room <br>
     */
    private enum type{
        SIMPLE,
        DOUBLE,
        FAMILIALE
    }

    /**
     * amount of beds in said room
     *<br>
     * why is this necessary again?
     */
    private int bedNumber;




    /**
     * is the room available?
     */
    private boolean isAvailable;

    /**
     * add a bed to the room
     */
    public Bed addBed(int id, String type){
        this.bedNumber+=1;
        return new Bed(id,type);
    }


}
