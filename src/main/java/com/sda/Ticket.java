package ParkingTicked.src.main.java.com.sda;

import java.time.Duration;

public class Ticket {
    private final int id;
    private final double price;
    private final Duration duration;
    private final String costumerName;
    private final boolean isMember;

    public Ticket(int id, double price, Duration duration, String costumerName, boolean isMember) {
        this.id = id;
        this.price = price;
        this.duration = duration;
        this.costumerName = costumerName;
        this.isMember = isMember;
    }
    //fddf

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
