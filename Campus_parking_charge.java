import java.util.Scanner;

// Abstract Base Class
abstract class Vehicle {
    protected int hours;

    public Vehicle(int hours) {
        this.hours = hours;
    }

    public abstract double calculateCharge();
    public abstract String getVehicleType();
}

// Bike Subclass: ₹10 per hour
class Bike extends Vehicle {
    public Bike(int hours) {
        super(hours);
    }

    @Override
    public double calculateCharge() {
        return hours * 10.0;
    }

    @Override
    public String getVehicleType() {
        return "BIKE";
    }
}

// Car Subclass: ₹30 for first hour + ₹20 for each additional hour
class Car extends Vehicle {
    public Car(int hours) {
        super(hours);
    }

    @Override
    public double calculateCharge() {
        if (hours <= 1) {
            return 30.0;
        }
        return 30.0 + (hours - 1) * 20.0;
    }

    @Override
    public String getVehicleType() {
        return "CAR";
    }
}

// Truck Subclass: ₹50 per hour, minimum charge ₹100
class Truck extends Vehicle {
    public Truck(int hours) {
        super(hours);
    }

    @Override
    public double calculateCharge() {
        double total = hours * 50.0;
        return Math.max(total, 100.0);
    }

    @Override
    public String getVehicleType() {
        return "TRUCK";
    }
}

// Main Class
public class Campus_parking_charge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();

        Vehicle[] vehicles = new Vehicle[n];
        double grandTotal = 0.0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int hours = sc.nextInt();

            switch (type) {
                case "BIKE":
                    vehicles[i] = new Bike(hours);
                    break;
                case "CAR":
                    vehicles[i] = new Car(hours);
                    break;
                case "TRUCK":
                    vehicles[i] = new Truck(hours);
                    break;
            }
        }

        // Processing using Polymorphism
        for (Vehicle vehicle : vehicles) {
            double charge = vehicle.calculateCharge();
            System.out.printf("%s: %.2f%n", vehicle.getVehicleType(), charge);
            grandTotal += charge;
        }

        System.out.printf("Total: %.2f%n", grandTotal);

        sc.close();
    }
}