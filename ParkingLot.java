package PakingLotModule;

// import java.time.LocalDateTime;
// import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;


class ParkingLot {
    private final int capacity = 80;
    private int totalVehicle = 0;
    private Map<Vehicle, String> totalVehicleInfo = new HashMap<>();

    public void acceptVehicle(Vehicle vehicle) {
        if (totalVehicle < capacity) {
            totalVehicle++;
            String currentTime = getCurrentTime();
            totalVehicleInfo.put(vehicle, currentTime);
            // return true;
            System.out.println("\n Vehicle accepted in Parking lot.");
            System.out.println("Your vehicle is in " + vehicle.getParkingSpaceString() + " with ID = " + vehicle.getID() + ". Please input the ID when checking out.");
        } else {
            System.out.println("\n Parking lot is full. Vehicle rejected.");
        }
        // return false;
    }

    public boolean isIDVehicleExistsInPakingLot(int ID) {
        for (Vehicle vehicle : totalVehicleInfo.keySet()) {
            if (vehicle.getID() == ID) {
                return true;
            }
        }
        return false;
    }

    public void removeVehicleByID(int ID) {
        for (Vehicle vehicle : totalVehicleInfo.keySet()) {
            if (vehicle.getID() == ID) {
                double parkingFee = calculateParkingFee(vehicle);
                System.out.println("Total parking fee for your " + vehicle.getType() + ": $" + parkingFee);
                totalVehicleInfo.remove(vehicle);
                totalVehicle--;
                return;
            }
        }
        System.out.println("Vehicle with ID " + ID + " not found in the parking lot.");
    }

    public String getCurrentTime() {
        SimpleDateFormat DateFormatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");  
        Date currentTimeDate = new Date();  
        return DateFormatter.format(currentTimeDate);
    }

    public double calculateParkingFee(Vehicle vehicle) {
        SimpleDateFormat DateFormatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");  

        Date currentTimeDate = new Date(); 
        long days = 1;
        double parkingFee = 0;
        String timeIn = totalVehicleInfo.get(vehicle);
        
        try {
            Date timeInDate = DateFormatter.parse(timeIn);

            long timeDifferenceMillis = currentTimeDate.getTime() - timeInDate.getTime();
            days = timeDifferenceMillis / (24 * 60 * 60 * 1000);

            if (days >= 1 && timeDifferenceMillis % (24 * 60 * 60 * 1000) != 0) {
                days++;
            }

            if (days < 1) {
                days = 1;
            }

            VehicleType vehicleType = vehicle.getType();
            if (vehicleType == VehicleType.BIKE) {
                parkingFee = days * 2;
            } else if (vehicleType == VehicleType.CAR) {
                parkingFee = days * 10;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return parkingFee;
    }
}