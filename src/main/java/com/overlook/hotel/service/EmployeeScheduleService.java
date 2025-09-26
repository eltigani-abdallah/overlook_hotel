package com.overlook.hotel.service;

import com.overlook.hotel.database.Entity.EmployeeSchedule;
import com.overlook.hotel.repository.EmployeeScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeScheduleService {

    private final EmployeeScheduleRepository employeeScheduleRepository;

    public List<EmployeeSchedule> getAllSchedules() {
        return employeeScheduleRepository.findAll();
    }

    public EmployeeSchedule getScheduleById(Long id) {
        return employeeScheduleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Schedule not found"));
    }

    public EmployeeSchedule createSchedule(EmployeeSchedule schedule) {
        return employeeScheduleRepository.save(schedule);
    }

    public EmployeeSchedule updateSchedule(Long id, EmployeeSchedule details) {
        EmployeeSchedule schedule = getScheduleById(id);
        schedule.setWorkSchedule(details.getWorkSchedule());
        schedule.setStartTime(details.getStartTime());
        schedule.setEndTime(details.getEndTime());
        schedule.setStatus(details.getStatus());
        schedule.setEmployee(details.getEmployee());
        schedule.setAdmin(details.getAdmin());
        return employeeScheduleRepository.save(schedule);
    }

    public void deleteSchedule(Long id) {
        employeeScheduleRepository.deleteById(id);
    }
}
