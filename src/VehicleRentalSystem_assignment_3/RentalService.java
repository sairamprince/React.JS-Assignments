package VehicleRentalSystem_assignment_3;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

class RentalService implements RentalCostCalculator {
    private List<Vehicle> vehicles;
    private List<Rental> rentals;

    
    public RentalService() {
        this.vehicles = new ArrayList<>();
        this.rentals = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public List<Vehicle> getAvailableVehicles() {
        List<Vehicle> availableVehicles = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            if (vehicle.isAvailable()) {
                availableVehicles.add(vehicle);
            }
        }
        return availableVehicles;
    }

    public Rental rentVehicle(Customer customer, Vehicle vehicle, LocalDateTime startTime, LocalDateTime endTime) {
        if (!vehicle.isAvailable()) {
            System.out.println("Vehicle is not available for rent.");
            return null;
        }

        Rental rental = new Rental(vehicle, customer, startTime, endTime);
        rentals.add(rental);
        vehicle.setAvailable(false);
        return rental;
    }
 
    @Override
    
    public BigDecimal calculateRentalCost(Rental rental) {
        LocalDateTime startTime = rental.getStartTime();
        LocalDateTime endTime = rental.getEndTime();
        long durationInHours = Duration.between(startTime, endTime).toHours();
        BigDecimal hourlyRate = new BigDecimal("1000");
        BigDecimal rentalCost = hourlyRate.multiply(BigDecimal.valueOf(durationInHours));
        //return BigDecimal.ZERO;
        return rentalCost;
    }

    public boolean returnVehicle(Rental rental) {
        Vehicle vehicle = rental.getRentedVehicle();
        if (rentals.contains(rental) && !vehicle.isAvailable()) {
            rentals.remove(rental);
            vehicle.setAvailable(true);
            return true;
        }
        return false;
    }
    public List<Rental> getRentals() {
        return rentals;
    }
}

