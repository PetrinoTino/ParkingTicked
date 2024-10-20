package com.sda.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "parking_slots")
public class ParkingSlot {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private boolean isAvailable;
    private String position;

    public ParkingSlot(int id, String position) {
        this.id = id;
        this.position = position;
        this.isAvailable = true;
    }
}