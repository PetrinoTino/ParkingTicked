package com.sda;

    import java.time.LocalDateTime;
import java.time.Duration;

    public class ParkingSection {
        private long id;
        private LocalDateTime entryTime;
        private LocalDateTime exitTime;
        private String licensePlate;

        public ParkingSection(long id, String licensePlate) {
            this.id = id;
            this.licensePlate = licensePlate;
            this.entryTime = LocalDateTime.now();
        }

        public void setExitTime(LocalDateTime exitTime) {
            this.exitTime = exitTime;
        }

        public Duration calculateDuration() {
            if (exitTime == null) {
                return Duration.between(entryTime, LocalDateTime.now());
            }
            return Duration.between(entryTime, exitTime);
        }

        public String getLicensePlate() {
            return licensePlate;
        }
    }

