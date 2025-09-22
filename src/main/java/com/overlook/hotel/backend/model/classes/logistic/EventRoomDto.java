package com.overlook.hotel.backend.model.classes.logistic;



import com.overlook.hotel.backend.model.classes.hr.user.EmployeeDto;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter @Setter @SuperBuilder
public class EventRoomDto extends RoomDto {

    @NonNull
    private EmployeeDto employeeResponsible;


}
