package com.sda.service;

import com.sda.dao.ParkingSlotDAO;
import com.sda.entity.ParkingSlot;

import java.util.List;

public class ParkingSlotService {

    private static final int TOTAL_SLOTS = 20;
    private final ParkingSlotDAO parkingSlotDAO;

    public ParkingSlotService() {
        this.parkingSlotDAO = new ParkingSlotDAO();
        initializeParkingSlots();
    }

    public void initializeParkingSlots() {
        for (int i = 0; i < TOTAL_SLOTS; i++) {
            ParkingSlot parkingSlot = new ParkingSlot(i, "Vendi " + (i + 1));
            parkingSlotDAO.saveParkingSlot(parkingSlot);
        }
    }

    public void saveParkingSlot(ParkingSlot parkingSlot) {
        parkingSlotDAO.saveParkingSlot(parkingSlot);
    }

    public List<ParkingSlot> getAvailableParkingSlots() {
        return parkingSlotDAO.getAvailableParkingSlots();
    }

    public int updateParkingSlotAvailability() {

        /*int availableSlotPosition = 0;
        for (ParkingSlot slot : availableSlots) {
            if (!slot.isAvailable()) {
                availableSlotPosition++;
            }
        }

        if (availableSlotPosition <= TOTAL_SLOTS) {
            parkingSlot.setAvailable(false);
        } else {
            System.out.println("Na vjen keq, nuk ka vende parkimi të disponueshme.");
            return;
        }*/
        List<ParkingSlot> availableSlots = parkingSlotDAO.getAvailableParkingSlots();
        if (availableSlots.isEmpty()) {
            System.out.println("Na vjen keq, nuk ka vende parkimi të disponueshme.");
            return -1;
        }

        ParkingSlot parkingSlot = availableSlots.get(0);
        parkingSlot.setAvailable(false);

        parkingSlotDAO.updateParkingSlotAvailability(parkingSlot);
        return parkingSlot.getId();
    }
}
