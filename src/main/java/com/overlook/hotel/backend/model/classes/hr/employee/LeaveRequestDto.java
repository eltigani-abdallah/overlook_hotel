package com.overlook.hotel.backend.model.classes.hr.employee;

import com.overlook.hotel.backend.model.classes.hr.user.EmployeeDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.time.LocalDate;


@Setter @Getter @Builder
public class LeaveRequestDto {

    @NonNull
    private int id;
    @NonNull
    private EmployeeDto requestMaker;
    @NonNull
    private LocalDate startDate;
    @NonNull
    private LocalDate endDate;
    @NonNull
    private String reason;

    private boolean isApproved=false;
}
