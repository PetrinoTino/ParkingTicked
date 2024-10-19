package com.sda;
import java.util.Scanner;
import java.util.List;
import java.time.LocalDateTime;

public class ParkingManagementSystem {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        DatabaseManager.testConnection();
        DatabaseManager.initializeDatabase();

        while (true) {
            System.out.println("\n--- Parking Tirana ---");
            System.out.println("1. Shto një makinë në parking");
            System.out.println("2. Gjenero biletë dhe llogarit tarifën");
            System.out.println("3. Shfaq vendet e lira të parkimit");
            System.out.println("4. Shfaq makinat aktualisht të parkuara");
            System.out.println("5. Shfaq fitimet totale");
            System.out.println("6. Dil");
            System.out.print("Zgjidhni një opsion: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addCar();
                    break;
                case 2:
                    generateTicket();
                    break;
                case 3:
                    showAvailableSlots();
                    break;
                case 4:
                    displayParkedCars();
                    break;
                case 5:
                    showTotalEarnings();
                    break;
                case 6:
                    System.out.println("Duke dalë nga sistemi...");
                    return;
                default:
                    System.out.println("Zgjedhje e pavlefshme. Ju lutem provoni përsëri.");
            }
        }
    }

    private static void addCar() {
        System.out.print("Vendosni targën e makinës: ");
        String licensePlate =   scanner.nextLine().trim();

        System.out.print("Vendosni emrin e klientit: ");
        String firstName = scanner.nextLine().trim();

        System.out.print("Vendosni mbiemrin e klientit: ");
        String lastName = scanner.nextLine().trim();

        System.out.print("A është klienti anëtar? (po/jo): ");
        boolean isMember = scanner.nextLine().trim().equalsIgnoreCase("po");

        List<ParkingSlot> availableSlots = DatabaseManager.getAvailableParkingSlots();
        if (availableSlots.isEmpty()) {
            System.out.println("Na vjen keq, nuk ka vende parkimi të disponueshme.");
            return;
        }
        ParkingSlot slot = availableSlots.get(0);
        DatabaseManager.updateParkingSlotAvailability(slot.getId(), false);

        Customer customer = new Customer((int) System.currentTimeMillis(), firstName, lastName, isMember);
        DatabaseManager.saveCustomer(customer);

        ParkingSection section = new ParkingSection((int) System.currentTimeMillis(), licensePlate, slot.getId());
        DatabaseManager.saveParkingSection(section);

        System.out.println("Makina u shtua me sukses në parking.");
    }

    private static void generateTicket() {
        System.out.print("Vendosni targën e makinës: ");
        String licensePlate = scanner.nextLine().trim();

        ParkingSection section = DatabaseManager.getParkingSectionByLicensePlate(licensePlate);
        if (section == null) {
            System.out.println("Makina nuk u gjet në parking.");
            return;
        }
        section.setExitTime(LocalDateTime.now());
        int slotId = section.getSlotId();

        System.out.print("Vendosni emrin e plotë të klientit: ");
        String customerName = scanner.nextLine().trim();

        System.out.print("A është klienti anëtar? (po/jo): ");
        boolean isMember = scanner.nextLine().trim().equalsIgnoreCase("po");

        Ticket ticket = new Ticket((int) System.currentTimeMillis(), section.calculateDuration(), customerName, isMember);
        DatabaseManager.saveTicket(ticket);

        DatabaseManager.updateParkingSlotAvailability(slotId, true);

        System.out.println("Bileta u gjenerua:");
        System.out.println(ticket);
    }

    private static void showAvailableSlots() {
        List<ParkingSlot> availableSlots = DatabaseManager.getAvailableParkingSlots();
        System.out.println("Vende parkimi të disponueshme: " + availableSlots.size() + " nga " + ParkingSlot.getTotalSlots());
        for (ParkingSlot slot : availableSlots) {
            System.out.println("Vendi " + slot.getId() + " në pozicionin " + slot.getPosition());
        }
    }

    private static void displayParkedCars() {
        List<ParkingSection> parkedCars = DatabaseManager.getCurrentlyParkedCars();
        System.out.println("Makinat aktualisht të parkuara:");
        for (ParkingSection section : parkedCars) {
            System.out.println("Targa: " + section.getLicensePlate() + ", Vendi: " + section.getSlotId());
        }
    }

    private static void showTotalEarnings() {
        double totalEarnings = DatabaseManager.getTotalEarnings();
        System.out.printf("Fitimet totale: $%.2f\n", totalEarnings);
    }
}