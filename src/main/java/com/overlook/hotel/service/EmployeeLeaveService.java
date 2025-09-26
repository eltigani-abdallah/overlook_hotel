package com.overlook.hotel.service;

import com.overlook.hotel.Entity.EmployeeLeave;
import com.overlook.hotel.repository.EmployeeLeaveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeLeaveService {

    private final EmployeeLeaveRepository employeeLeaveRepository;

    public List<EmployeeLeave> getAllLeaves() {
        return employeeLeaveRepository.findAll();
    }

    public EmployeeLeave getLeaveById(Long id) {
        return employeeLeaveRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Leave not found"));
    }

    public EmployeeLeave createLeave(EmployeeLeave leave) {
        return employeeLeaveRepository.save(leave);
    }

    public EmployeeLeave updateLeave(Long id, EmployeeLeave details) {
        EmployeeLeave leave = getLeaveById(id);
        leave.setStartDate(details.getStartDate());
        leave.setEndDate(details.getEndDate());
        leave.setStatus(details.getStatus());
        leave.setEmployee(details.getEmployee());
        leave.setAdmin(details.getAdmin());
        return employeeLeaveRepository.save(leave);
    }

    public void deleteLeave(Long id) {
        employeeLeaveRepository.deleteById(id);
    }
}
