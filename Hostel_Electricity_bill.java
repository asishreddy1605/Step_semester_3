import java.util.Scanner;

// Abstract Base Class
abstract class Room {
    protected int units;

    public Room(int units) {
        this.units = units;
    }

    public abstract double calculateBill();
    public abstract String getRoomType();
}

// Single Room Subclass: ₹8 per unit
class SingleRoom extends Room {
    public SingleRoom(int units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        return units * 8.0;
    }

    @Override
    public String getRoomType() {
        return "SINGLE";
    }
}

// Shared Room Subclass: ₹6 per unit, divided equally among occupants
class SharedRoom extends Room {
    private int occupants;

    public SharedRoom(int units, int occupants) {
        super(units);
        this.occupants = occupants;
    }

    @Override
    public double calculateBill() {
        return (units * 6.0) / occupants;
    }

    @Override
    public String getRoomType() {
        return "SHARED";
    }
}

// AC Room Subclass: ₹10 per unit + ₹200 fixed charge
class ACRoom extends Room {
    public ACRoom(int units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        return (units * 10.0) + 200.0;
    }

    @Override
    public String getRoomType() {
        return "AC";
    }
}

// Main Class
public class Hostel_Electricity_bill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();

        Room[] rooms = new Room[n];
        double grandTotal = 0.0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int units = sc.nextInt();

            switch (type) {
                case "SINGLE":
                    rooms[i] = new SingleRoom(units);
                    break;
                case "SHARED":
                    int occupants = sc.nextInt();
                    rooms[i] = new SharedRoom(units, occupants);
                    break;
                case "AC":
                    rooms[i] = new ACRoom(units);
                    break;
            }
        }

        // Processing using Polymorphism
        for (Room room : rooms) {
            double bill = room.calculateBill();
            System.out.printf("%s: %.2f%n", room.getRoomType(), bill);
            grandTotal += bill;
        }

        System.out.printf("Total: %.2f%n", grandTotal);

        sc.close();
    }
}