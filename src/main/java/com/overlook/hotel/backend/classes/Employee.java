package com.overlook.hotel.backend.classes;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class Employee extends User {
    public Employee(int id, Date birthDate, String gender, String firstName, String lastName, String passwordHash, String email, String address, String phoneNumber){
        super(id, birthDate, gender, firstName, lastName, passwordHash, email, address, phoneNumber);
    }

    private String presence;
    private String title;

    public void modifyReservation(){}
    public void cancelREservaiton(){}



}
