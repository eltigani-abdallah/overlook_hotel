package com.overlook.hotel.dto.logisticDto;



import com.overlook.hotel.dto.userDto.EmployeeDto;
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
