package com.sda.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "parking_sections")
public class ParkingSection {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private String licensePlate;
    private int slotId;

    public ParkingSection(int id, String licensePlate, int slotId) {
        this.id = id;
        this.licensePlate = licensePlate;
        this.slotId = slotId;
        this.entryTime = LocalDateTime.now();
    }

    public Duration calculateDuration() {
        return Duration.between(entryTime, Objects.requireNonNullElseGet(exitTime, LocalDateTime::now));
    }
}
