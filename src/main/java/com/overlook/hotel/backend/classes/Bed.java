package com.overlook.hotel.backend.classes;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Setter @Getter
public class Bed {

    public Bed(int id, String type){
        this.id=id;
        if (Objects.equals(type, "SIMPLE") || Objects.equals(type, "DOUBLE")){
            this.bedType=type;
        } else {
            System.out.println("bed id: "+ this.id +" has been forcibly made into a simple bed");
        }
    }

    /**
     * bed ID
     *
     */
    private int id;

    /**
     * bed type
     */
    private String bedType;

}
