
package com.overlook.hotel.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Loyalty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer visitedNumber;
    private String status;

    @OneToOne
    @JoinColumn(name = "userId")
    private User user;
}
