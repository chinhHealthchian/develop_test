package PakingLotModule;

import java.util.Random;

enum ParkingSpace {
    A, B
}

enum VehicleType {
    CAR(2.0, 10.0),
    BIKE(0.8, 2.0);

    private final double minWidth;
    private final double parkingPrice;

    VehicleType(double minWidth, double parkingPrice) {
        this.minWidth = minWidth;
        this.parkingPrice = parkingPrice;
    }

    public double getMinWidth() {
        return minWidth;
    }
 
    public double getParkingPrice() {
        return parkingPrice;
    }

}

class Vehicle {
    private int ID;
    private double minWidth;
    private VehicleType type;
    private ParkingSpace parkingSpace;

    public Vehicle(VehicleType vehicleType) {
        this.ID = randomIDVehicle();
        this.type = vehicleType;
        this.minWidth = vehicleType.getMinWidth();
        this.parkingSpace = setParkingSpace(minWidth);
    }

    public double getMinWidth() {
        return minWidth;
    }

    public ParkingSpace setParkingSpace(double minWidth) {
        if (minWidth >= 2) {
            return ParkingSpace.A;
        } 
        return ParkingSpace.B;
    }

    public String getParkingSpaceString() {
        if (parkingSpace == ParkingSpace.A) {
            return "space A";
        } 
        return "space B";
    }

    public VehicleType getType() {
        return type;
    }

    public int getID() {
        return ID;
    }

    public int randomIDVehicle() {
        Random random = new Random();
        int ID = 100 + random.nextInt(900);
        return ID;
    }
}

