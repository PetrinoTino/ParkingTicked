package com.sda;



import java.time.Duration;

public class Ticket {
    private final int id;
    private final double price;
    private final Duration duration;
    private final String customerName;
    private final boolean isMember;
    private final String companyName; // Emri i kompanisë


    private static final double RATE_PER_HOUR = 5.0;
    private static final double RATE_PER_MINUTE = 0.1;

    public Ticket(int id, Duration duration, String customerName, boolean isMember) {
        if (id <= 0) throw new IllegalArgumentException("ID must be positive.");
        if (duration.isNegative() || duration.isZero()) throw new IllegalArgumentException("Duration must be positive.");
        if (customerName == null || customerName.trim().isEmpty()) throw new IllegalArgumentException("Customer name cannot be null or empty.");

        this.id = id;
        this.duration = duration;
        this.customerName = customerName;
        this.isMember = isMember;
        this.companyName = "Parking Tirana";
        this.price = calculatePrice();
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
