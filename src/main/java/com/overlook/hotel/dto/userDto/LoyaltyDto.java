package com.overlook.hotel.dto.userDto;

import com.overlook.hotel.database.Entity.LoyaltyStatus;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoyaltyDto {

    private Integer id;
    private Integer visitedNumber;
    private LoyaltyStatus status;
    private ClientDto client;
}
