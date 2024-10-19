package com.sda;



import java.time.Duration;

    public class Ticket {
        private int id;
        private double price;
        private Duration duration;
        private String customerName;
        private boolean isMember;

        public Ticket(int id, Duration duration, String customerName, boolean isMember) {
            this.id = id;
            this.duration = duration;
            this.customerName = customerName;
            this.isMember = isMember;
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

        private double calculatePrice() {
            double basePrice = duration.toHours() * 5.0; // $5 per hour
            if (isMember) {
                return basePrice * 0.8; // 20% discount for members
            }
            return basePrice;
        }

        @Override
        public String toString() {
            return "Ticket{" +
                    "id=" + id +
                    ", price=" + price +
                    ", duration=" + duration +
                    ", customerName='" + customerName + '\'' +
                    ", isMember=" + isMember +
                    '}';
        }
    }
