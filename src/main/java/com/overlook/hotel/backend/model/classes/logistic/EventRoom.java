package com.overlook.hotel.backend.model.classes.logistic;


import com.overlook.hotel.backend.model.classes.hr.users.Employee;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EventRoom extends Room{
    public EventRoom(int id, String type, String name, int capacity, Employee employeeResponsible){
        super(id, type, name, capacity);
        this.employeeResponsible=employeeResponsible;
    }

    private Employee employeeResponsible;


}
