package com.overlook.hotel.controller;

import com.overlook.hotel.Entity.EmployeeLeave;
import com.overlook.hotel.service.EmployeeLeaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leaves")
@RequiredArgsConstructor
public class EmployeeLeaveController {

    private final EmployeeLeaveService employeeLeaveService;

    @GetMapping
    public List<EmployeeLeave> getAllLeaves() {
        return employeeLeaveService.getAllLeaves();
    }

    @GetMapping("/{id}")
    public EmployeeLeave getLeaveById(@PathVariable Long id) {
        return employeeLeaveService.getLeaveById(id);
    }

    @PostMapping
    public EmployeeLeave createLeave(@RequestBody EmployeeLeave leave) {
        return employeeLeaveService.createLeave(leave);
    }

    @PutMapping("/{id}")
    public EmployeeLeave updateLeave(@PathVariable Long id, @RequestBody EmployeeLeave leave) {
        return employeeLeaveService.updateLeave(id, leave);
    }

    @DeleteMapping("/{id}")
    public void deleteLeave(@PathVariable Long id) {
        employeeLeaveService.deleteLeave(id);
    }
}
