package com.sda.service;

import com.sda.dao.CustomerDAO;
import com.sda.entity.Customer;

public class CustomerService {

    private final CustomerDAO customerDAO;

    public CustomerService() {
        this.customerDAO = new CustomerDAO();
    }

    public void saveCustomer(String firstName, String lastName, boolean isMember) {
        if (firstName == null || firstName.trim().isEmpty()) {
            System.out.println("Error: Emri nuk mund te jet bosh.");
            return;
        }
        if (lastName == null || lastName.trim().isEmpty()) {
            System.out.println("Error: Mbiemri nuk mund te jet bosh.");
            return;
        }

        Customer customer = new Customer(firstName, lastName, isMember);
        customerDAO.saveCustomer(customer);
    }
}
