package com.sda;
public class ParkingSlot {
    private long id;
    private boolean isAvailable;
    private String position;

    public ParkingSlot(long id, String position) {
        this.id = id;
        this.position = position;
        this.isAvailable = true;
    }

    public long getId() {
        return id;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailability(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public String getPosition() {
        return position;
    }
}