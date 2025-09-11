
package com.overlook.hotel.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String message;
    private Integer stars;
    private LocalDate feedbackDate;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
}

