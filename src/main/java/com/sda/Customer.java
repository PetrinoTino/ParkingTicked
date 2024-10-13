package com.sda;


    public class Customer {
        private long id;
        private String firstName;
        private String lastName;
        private boolean isMember;

        public Customer(long id, String firstName, String lastName, boolean isMember) {
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
            this.isMember = isMember;
        }

        public long getId() {
            return id;
        }

        public String getFullName() {
            return firstName + " " + lastName;
        }

        public boolean isMember() {
            return isMember;
        }
    }

