package com.overlook.hotel.backend.model.classes.dto.logistic;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class EventDto {
    private Long id;
    private String eventName;
    private String eventDescription;
    private LocalDate eventDate;

}
