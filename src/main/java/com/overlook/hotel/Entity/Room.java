
package com.overlook.hotel.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String roomNumber;
    private Double price;
    private String type;
    private String bedType;
    private Boolean isAvailable;
}

