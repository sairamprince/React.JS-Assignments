package VehicleRentalSystem_assignment_3;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		RentalService rentalService = new RentalService();

		Scanner scanner = new Scanner(System.in);
		int option;

		do {
			System.out.println("");
			System.out.println("------ ||Welcome to Vehicle Rental System|| ------");
			System.out.println("");
			System.out.println("       1. Add a vehicle");
			System.out.println("       2. Available vehicles");
			System.out.println("       3. Rent a vehicle");
			System.out.println("       4. Calculate rental cost");
			System.out.println("       5. Return a vehicle");
			System.out.println("       6. Quit");
			System.out.println("");
			System.out.print("       Enter your option: ");
			option = scanner.nextInt();
			scanner.nextLine();

			switch (option) {
			
			case 1:
				System.out.print("       Enter license plate: ");
				String licensePlate = scanner.nextLine();
				System.out.print("       Enter make: ");
				String make = scanner.nextLine();
				System.out.print("       Enter model: ");
				String model = scanner.nextLine();
				Vehicle vehicle = new Car(licensePlate, make, model);
				rentalService.addVehicle(vehicle);
				System.out.println("       Vehicle added successfully.");
				break;
			case 2:
				List<Vehicle> availableVehicles = rentalService.getAvailableVehicles();
				System.out.println("       Available vehicles:");
				for (Vehicle v : availableVehicles) {
					System.out.println("       "+v.getLicensePlate() + " - " + v.getMake() + " " + v.getModel());
				}
				break;
			case 3:
				
				System.out.print("       Enter your first name: ");
				String firstName = scanner.nextLine();
				System.out.print("       Enter your last name: ");
				String lastName = scanner.nextLine();
				System.out.print("       Enter your ID: ");
				String id = scanner.nextLine();
				Customer customer = new Customer(firstName, lastName, id);

				System.out.print("       Enter the license plate of the vehicle to rent: ");
				String rentLicensePlate = scanner.nextLine();
				Vehicle rentVehicle = null;
				for (Vehicle v : rentalService.getAvailableVehicles()) {
					if (v.getLicensePlate().equalsIgnoreCase(rentLicensePlate)) {
						rentVehicle = v;
						break;
					}
				}

				if (rentVehicle != null) {
					LocalDateTime startTime = LocalDateTime.now();
					LocalDateTime endTime = startTime.plusHours(3);
					Rental rental = rentalService.rentVehicle(customer, rentVehicle, startTime, endTime);
					System.out.println("       Vehicle rented successfully.");
				} else {
					System.out.println("       Invalid license plate or vehicle is not available for rent.");
				}
				break;
				
			case 4:
				System.out.print("       Enter the license plate of the rented vehicle: ");
				String rentedLicensePlate = scanner.nextLine();
				Rental rentedVehicle = null;
				for (Rental rental : rentalService.getRentals()) {
					if (rental.getRentedVehicle().getLicensePlate().equalsIgnoreCase(rentedLicensePlate)) {
						rentedVehicle = rental;
						break;
					}
				}

				if (rentedVehicle != null) {
					BigDecimal rentalCost = rentalService.calculateRentalCost(rentedVehicle);
					System.out.println("       Rental cost: " + rentalCost);
				} else {
					System.out.println("       Invalid license plate or vehicle is not rented.");
				} 
				break;
				
			case 5:
				System.out.print("       Enter the license plate of the rented vehicle to return: ");
				String returnLicensePlate = scanner.nextLine();
				Rental returnRental = null;
				for (Rental rental : rentalService.getRentals()) {                           
					if (rental.getRentedVehicle().getLicensePlate().equalsIgnoreCase(returnLicensePlate)) {
						returnRental = rental;
						break;
					}
				}

				if (returnRental != null) {
					boolean returned = rentalService.returnVehicle(returnRental);
					if (returned) {
						System.out.println("       Vehicle returned successfully.");
					} else {
						System.out.println("      Error returning the vehicle.");
					}
				} else {
					System.out.println("          Invalid license plate or vehicle is not rented.");
				}
				break;
				
			case 6:
				System.out.println("       Thank you for using the vehicle rental system.....:)");
				break;
			default:
				System.out.println("       Invalid choice. Please try again.");
				break;
			}
			System.out.println();
		} while (option != 6);

		scanner.close();
	}
}
