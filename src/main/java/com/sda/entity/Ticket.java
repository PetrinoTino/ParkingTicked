package com.sda.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Duration;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private double price;
    private String customerName;
    private boolean isMember;
    private Duration duration;

    public Ticket(int id, double price, String customerName, boolean isMember, Duration duration) {
        this.id = id;
        this.price = price;
        this.customerName = customerName;
        this.isMember = isMember;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return String.format("Ticket{id=%d, price=%.2f, duration=%s, customerName='%s', isMember=%b}",
                id, price, getDurationInHoursAndMinutes(), customerName, isMember);
    }

    public String getDurationInHoursAndMinutes() {
        long hours = duration.toHours();
        long minutes = duration.toMinutes() % 60;
        return String.format("%d ore dhe %d minuta", hours, minutes);
    }
}
