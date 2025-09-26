package com.overlook.hotel.dto.userDto;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.time.LocalDate;


@Setter @Getter @Builder
public class LeaveRequestDto {

    private Long id;
    @NonNull
    private EmployeeDto requestMaker;
    @NonNull
    private LocalDate startDate;
    @NonNull
    private LocalDate endDate;
    @NonNull
    private String status;
    @NonNull
    private AdminDto admin;
}
