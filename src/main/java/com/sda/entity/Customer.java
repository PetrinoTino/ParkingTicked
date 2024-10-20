package com.sda.entity;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String firstName;
    private String lastName;
    private boolean isMember;

    public Customer(String firstName, String lastName, boolean isMember) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.isMember = isMember;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }
}

