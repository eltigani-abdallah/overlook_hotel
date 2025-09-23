package com.overlook.hotel.backend.model.classes.hr.employee;

import com.overlook.hotel.backend.model.classes.hr.user.AdminDto;
import com.overlook.hotel.backend.model.classes.hr.user.EmployeeDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.time.LocalDate;


@Setter @Getter @Builder
public class LeaveRequestDto {

    @NonNull
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
