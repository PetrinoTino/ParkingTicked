package com.sda;

import java.time.Duration;

public class Ticket {
    private final int id;
    private final double price;
    private final String customerName;
    private final boolean isMember;
    private final Duration duration;
    private static final double RATE_PER_HOUR = 10.0;
    private static final double RATE_PER_MINUTE = 0.5;

    public Ticket(int id, double price, String customerName, boolean isMember, Duration duration) {
        this.id = id;
        this.price = price;
        this.customerName = customerName;
        this.isMember = isMember;
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public Duration getDuration() {
        return duration;
    }

    public String getCustomerName() {
        return customerName;
    }

    public boolean isMember() {
        return isMember;
    }

    public double calculatePrice() {
        long hours = duration.toHours();
        long minutes = duration.toMinutes() % 60;

        double basePrice = (hours * RATE_PER_HOUR) + (minutes * RATE_PER_MINUTE);
        return isMember ? basePrice * 0.8 : basePrice;
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
