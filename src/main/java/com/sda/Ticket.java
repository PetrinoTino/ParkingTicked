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

    public String getCostumerName() {
        return costumerName;
    }

    public boolean isMember() {
        return isMember;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", price=" + price +
                ", duration=" + duration +
                ", costumerName='" + costumerName + '\'' +
                ", isMember=" + isMember +
                '}';
    }
}
