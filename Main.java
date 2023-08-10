package PakingLotModule;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n \n Select an option:");
            System.out.println("1. Add Vehicle");
            System.out.println("2. Remove Vehicle");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.println("Enter vehicle type (CAR or BIKE):");
                    String vehicleTypeStr = scanner.nextLine();
                    VehicleType vehicleType = VehicleType.valueOf(vehicleTypeStr);
                    
                    Vehicle vehicle = new Vehicle(vehicleType);
                    parkingLot.acceptVehicle(vehicle);
                    break;
                
                case 2:
                    System.out.println("Enter vehicle ID to remove:");
                    int ID = scanner.nextInt();
                    scanner.nextLine(); 
                    parkingLot.removeVehicleByID(ID);
                    break;
                
                case 3:
                    System.out.println("See you again.");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}
