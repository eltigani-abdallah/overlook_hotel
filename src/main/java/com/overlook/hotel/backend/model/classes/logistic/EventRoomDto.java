package com.overlook.hotel.backend.model.classes.logistic;



import com.overlook.hotel.backend.model.classes.hr.users.EmployeeDto;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EventRoomDto extends RoomDto {
    public EventRoomDto(int id, String type, String name, int capacity, EmployeeDto employeeResponsible){
        super(id, type, name, capacity);
        this.employeeResponsible=employeeResponsible;
    }

    private EmployeeDto employeeResponsible;


}
