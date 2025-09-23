package com.overlook.hotel.backend.model.classes.dto.hr.user;


import com.overlook.hotel.backend.model.classes.dto.logistic.ReservationDto;
import com.overlook.hotel.backend.model.classes.dto.logistic.RoomDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.ArrayList;

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

    private String note;

    /**
     * reservation history
     */
    @Builder.Default
    private ArrayList<ReservationDto> reservationHistoryDto = new ArrayList<ReservationDto>();


    public ReservationDto reserveRoom(Long id, int adultAmount, int childAmount, LocalDate startDate, LocalDate endDate, RoomDto roomToReserve){

        if (startDate.isAfter(endDate)){
            System.err.println("Start date must be before the end date");
            return null;
            /// do something here for reservation failure
        }

        ReservationDto newReservationDto = ReservationDto.builder()
                .id(id)
                .customer(this)
                .adultAmount(adultAmount)
                .childAmount(childAmount)
                .startDate(startDate)
                .endDate(endDate)
                .isApproved(true)
                .roomToReserve(roomToReserve)
                .build();
        this.reservationHistoryDto.add(newReservationDto);
        return newReservationDto;
    }
}
