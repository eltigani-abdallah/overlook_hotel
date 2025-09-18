package com.overlook.hotel.backend.model.classes.hr;

import com.overlook.hotel.backend.model.classes.hr.users.EmployeeDto;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import java.util.Date;

@Setter @Getter @Builder
public class LeaveRequestDto {

    @NonNull
    private int id;
    @NonNull
    private EmployeeDto requestMaker;
    @NonNull
    private Date startDate;
    @NonNull
    private Date endDate;
    @NonNull
    private String reason;

    private boolean isApproved=false;
}
