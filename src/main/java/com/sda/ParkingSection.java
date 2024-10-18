package com.sda;

    import java.time.LocalDateTime;
import java.time.Duration;

    public class ParkingSection {
        private int id;
        private String licensePlate;
        private int slotId;
        private int entryHour;
        private int exitHour;

        public ParkingSection(int id, String licensePlate, int slotId, int entryHour,int exitHour) {
            this.id = id;
            this.licensePlate = licensePlate;
            this.slotId = slotId;
            this.entryHour = this.entryHour;
            this.exitHour = -1;
        }

        public ParkingSection(int id, String licensePlate, int slotId) {
        }

        public int getId() {
            return id;
        }

        public String getLicensePlate() {
            return licensePlate;
        }

        public int getSlotId() {
            return slotId;
        }

        public int getEntryHour() {
            return entryHour;
        }

        public int getExitHour() {
            return exitHour;
        }
        public void setExitHour(int exitHour) {
            if (exitHour < entryHour) {
                throw new IllegalArgumentException("Exit hour cannot be before entry hour");
            }
            this.exitHour = exitHour;
        }
        public int calculateHoursParked() {
            if (exitHour == -1) {
                throw new IllegalStateException("Car has not exited yet");
            }
            return exitHour - entryHour;
        }
        public double calculateFee(double hourlyRate) {
            int hoursParked = calculateHoursParked();
            return hoursParked * hourlyRate;
        }
        @Override
        public String toString() {
            return "ParkingSection{" +
                    "id=" + id +
                    ", licensePlate='" + licensePlate + '\'' +
                    ", slotId=" + slotId +
                    ", entryHour=" + entryHour +
                    ", exitHour=" + (exitHour == -1 ? "Still parked" : exitHour) +
                    '}';
        }
    }

