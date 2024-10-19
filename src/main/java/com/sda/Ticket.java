package com.sda;

import java.time.Duration;

public class Ticket {
    private final int id;
    private final double price;

    private final String costumerName;
    private final boolean isMember;

    public Ticket(int id, double price, String costumerName, boolean isMember) {
        this.id = id;
        this.price = price;
        this.costumerName = costumerName;
        this.isMember = isMember;
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

    public String getCompanyName() {
        return companyName;
    }

    private double calculatePrice() {
        long hours = duration.toHours();
        long minutes = duration.toMinutes() % 60;


        double basePrice = (hours * RATE_PER_HOUR) + (minutes * RATE_PER_MINUTE);

        // Zbritja për anëtarët
        return isMember ? basePrice * 0.8 : basePrice;
    }

    public String getDurationInHoursAndMinutes() {
        long hours = duration.toHours();
        long minutes = duration.toMinutes() % 60;
        return String.format("%d ore dhe %d minuta", hours, minutes);
    }

    @Override
    public String toString() {
        return String.format("Ticket{id=%d, price=%.2f, duration=%s, customerName='%s', isMember=%b, companyName='%s'}",
                id, price, getDurationInHoursAndMinutes(), customerName, isMember, companyName);
    }
}
