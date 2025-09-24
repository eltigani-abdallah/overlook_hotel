package com.overlook.hotel.backend.model.classes.dto.logistic;



import com.overlook.hotel.backend.model.classes.dto.hr.user.EmployeeDto;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter @Setter @SuperBuilder
public class EventRoomDto extends RoomDto {

    @NonNull
    private EmployeeDto employeeResponsible;
    private EventDto event;


}
