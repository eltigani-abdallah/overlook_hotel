package com.overlook.hotel.backend.model.classes.hr;

import com.overlook.hotel.backend.model.classes.hr.users.Employee;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter @Getter @Builder
public class LeaveRequest {

    private int id;
    private Employee requestMaker;
    private Date startDate;
    private Date endDate;
    private String reason;
    private boolean isApproved;
}
