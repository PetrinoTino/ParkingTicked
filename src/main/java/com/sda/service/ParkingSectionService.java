package com.sda.service;

import com.sda.dao.ParkingSectionDAO;
import com.sda.entity.ParkingSection;

import java.util.List;

public class ParkingSectionService {

    private final ParkingSectionDAO parkingSectionDAO;

    public ParkingSectionService() {
        this.parkingSectionDAO = new ParkingSectionDAO();
    }

    public void saveParkingSection(String licensePlate, int slotId) {
        if (licensePlate == null || licensePlate.trim().isEmpty()) {
            System.out.println("Error: Targa nuk mund te jete bosh.");
            return;
        }

        ParkingSection section = new ParkingSection((int) System.currentTimeMillis(), licensePlate, slotId);
        parkingSectionDAO.saveParkingSection(section);
    }

    public List<ParkingSection> getCurrentlyParkedCars() {
        return parkingSectionDAO.getCurrentlyParkedCars();
    }

    public ParkingSection getParkingSectionByLicensePlate(String licensePlate) {
        return parkingSectionDAO.getParkingSectionByLicensePlate(licensePlate);
    }
}
