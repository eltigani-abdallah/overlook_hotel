package com.overlook.hotel.backend.model.classes.hr.user;


import com.overlook.hotel.backend.model.classes.logistic.ReservationDto;
import com.overlook.hotel.backend.model.classes.logistic.RoomDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.Date;

/**
 * @brief clients of the hotel
 */
@Getter @Setter @SuperBuilder
public class ClientDto extends UserDto {

    /**
     * points awarded to loyal customers.<br>
     * need to think about how to award said points<br>
     * economy I guess
     */
    private int loyaltyPoints;

    /**
     * reservation history
     */
    @Builder.Default
    private ArrayList<ReservationDto> reservationHistoryDto = new ArrayList<ReservationDto>();

    @Override
    public ReservationDto reserveRoom(int id, int guestAmount, Date startDate, Date endDate, ArrayList<RoomDto> roomDtoList){
        ArrayList<RoomDto> validReservations= new ArrayList<RoomDto>();
        if (startDate.after(endDate)){
            System.err.println("Start date must be before the end date");
            return null;
            /// do something here for reservation failure
        }
        for (RoomDto roomDto : roomDtoList){
            if (guestAmount> roomDto.getCapacity()){
                System.out.println(roomDto.getName()+" cannot be reserved; guests exceed capacity");
                continue;
            }
            validReservations.add(roomDto);
        }
        ReservationDto newReservationDto = ReservationDto.builder()
                .id(id)
                .customer(this)
                .guestAmount(guestAmount)
                .startDate(startDate)
                .endDate(endDate)
                .isApproved(true)
                .roomDtoList(validReservations)
                .build();
        this.reservationHistoryDto.add(newReservationDto);
        return newReservationDto;
    }
}
