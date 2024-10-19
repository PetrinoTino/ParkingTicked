package com.sda;


import java.time.LocalDate;

public class Customer {
    private int id;
    private String firstName;
    private String lastName;
    private boolean isMember;
    private LocalDate membershipStartDate;
    private String licensePlate;
    private String emergencyContact;
    private String gender;
    private boolean isDisabled;

    public Customer(int id, String firstName, String lastName, boolean isMember,
                    LocalDate membershipStartDate, String licensePlate, String emergencyContact,
                    String gender, boolean isDisabled) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isMember = isMember;
        this.membershipStartDate = membershipStartDate;
        this.licensePlate = licensePlate;
        this.emergencyContact = emergencyContact;
        this.gender = gender;
        this.isDisabled = isDisabled;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public boolean isMember() {
        return isMember;
    }

    public LocalDate getMembershipStartDate() {
        return membershipStartDate;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public String getGender() {
        return gender;
    }

    public boolean isDisabled() {
        return isDisabled;
    }

    public void updateContactInfo(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }
}