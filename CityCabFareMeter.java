import java.util.Scanner;

// Interface for cabs that support night service
interface NightServiceable {
    default double getNightSurcharge(double baseFare) {
        return baseFare * 0.20;
    }
}

// Abstract Base Class for all Cabs
abstract class Cab {
    protected String cabType;

    public Cab(String cabType) {
        this.cabType = cabType;
    }

    public abstract double getRatePerKm();

    // Minimum fare rule written in one shared place
    public double calculateBaseFare(double distance) {
        double rawFare = distance * getRatePerKm();
        return Math.max(rawFare, 100.0);
    }

    public String getCabType() {
        return cabType;
    }
}

// Mini Cab (No Night Service)
class MiniCab extends Cab {
    public MiniCab() {
        super("MINI");
    }

    @Override
    public double getRatePerKm() {
        return 10.0;
    }
}

// Sedan Cab (Supports Night Service)
class SedanCab extends Cab implements NightServiceable {
    public SedanCab() {
        super("SEDAN");
    }

    @Override
    public double getRatePerKm() {
        return 14.0;
    }
}

// SUV Cab (Supports Night Service)
class SuvCab extends Cab implements NightServiceable {
    public SuvCab() {
        super("SUV");
    }

    @Override
    public double getRatePerKm() {
        return 18.0;
    }
}

// Main Driver Class
public class CityCabFareMeter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();

        double totalFareCollected = 0.0;

        for (int i = 0; i < n; i++) {
            String cabType = scanner.next();
            double km = scanner.nextDouble();
            String time = scanner.next();

            Cab cab = null;

            switch (cabType.toUpperCase()) {
                case "MINI":
                    cab = new MiniCab();
                    break;
                case "SEDAN":
                    cab = new SedanCab();
                    break;
                case "SUV":
                    cab = new SuvCab();
                    break;
            }

            if (cab != null) {
                boolean isNight = time.equalsIgnoreCase("NIGHT");

                if (isNight && !(cab instanceof NightServiceable)) {
                    System.out.printf("%s: night service not available%n", cab.getCabType());
                } else {
                    double fare = cab.calculateBaseFare(km);
                    if (isNight) {
                        fare += ((NightServiceable) cab).getNightSurcharge(fare);
                    }
                    totalFareCollected += fare;
                    System.out.printf("%s: %.2f%n", cab.getCabType(), fare);
                }
            }
        }

        System.out.printf("Total: %.2f%n", totalFareCollected);
        scanner.close();
    }
}