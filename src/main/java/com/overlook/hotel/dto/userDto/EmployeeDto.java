package com.overlook.hotel.dto.userDto;

import com.overlook.hotel.dto.logisticDto.ReservationDto;

import static com.overlook.hotel.helper.Util.stringToDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;




@Getter @Setter @SuperBuilder @NoArgsConstructor
public class EmployeeDto extends UserDto {


    private String presence;
    private String title;
    private String role;




    public void modifyReservation(ReservationDto reservationDto, ReservationDto.FieldToModify field, String value){
        switch (field) {
            case ADULTAMOUNT ->
                reservationDto.setAdultAmount(Integer.parseInt(value));
            case CHILDAMOUNT ->
                reservationDto.setChildAmount(Integer.parseInt(value));
            case STARTDATE ->
                reservationDto.setStartDate(stringToDate(value));
            case ENDDATE ->
                reservationDto.setEndDate(stringToDate(value));
            case EVENTNAME ->
                reservationDto.setEventName(value);
        }
    }


    public void cancelReservation(ReservationDto reservationDto){
        reservationDto.setApproved(false);
    }

    public LeaveRequestDto requestLeave(Long id, LocalDate startDate, LocalDate endDate){
        return LeaveRequestDto.builder()
            .id(id)
            .requestMaker(this)
            .startDate(startDate)
            .endDate(endDate)
            .status("Pending")
            .build();
    }




}
