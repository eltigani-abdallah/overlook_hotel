package com.overlook.hotel.controller;

import com.overlook.hotel.database.Entity.EmployeeSchedule;
import com.overlook.hotel.service.EmployeeScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schedules")
@RequiredArgsConstructor
public class EmployeeScheduleController {

    private final EmployeeScheduleService employeeScheduleService;

    @GetMapping
    public List<EmployeeSchedule> getAllSchedules() {
        return employeeScheduleService.getAllSchedules();
    }

    @GetMapping("/{id}")
    public EmployeeSchedule getScheduleById(@PathVariable Long id) {
        return employeeScheduleService.getScheduleById(id);
    }

    @PostMapping
    public EmployeeSchedule createSchedule(@RequestBody EmployeeSchedule schedule) {
        return employeeScheduleService.createSchedule(schedule);
    }

    @PutMapping("/{id}")
    public EmployeeSchedule updateSchedule(@PathVariable Long id, @RequestBody EmployeeSchedule schedule) {
        return employeeScheduleService.updateSchedule(id, schedule);
    }

    @DeleteMapping("/{id}")
    public void deleteSchedule(@PathVariable Long id) {
        employeeScheduleService.deleteSchedule(id);
    }
}
