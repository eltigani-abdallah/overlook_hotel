

package com.overlook.hotel.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate workSchedule;
    private LocalTime startTime;
    private LocalTime endTime;
    private String status;

    @ManyToOne
    @JoinColumn(name = "employeeId")
    private Employee employee;
}
