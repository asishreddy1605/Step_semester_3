import java.util.Scanner;

// Interface for appliances supporting Saver Mode
interface SaverMode {
    default double applySaverDiscount(double units) {
        return units * 0.75; // 25% reduction
    }
}

// Abstract Base Class for all Appliances
abstract class Appliance {
    protected String name;
    protected double powerRating; // in Watts

    public Appliance(String name, double powerRating) {
        this.name = name;
        this.powerRating = powerRating;
    }

    public double calculateUnits(double hours) {
        return (powerRating * hours) / 1000.0;
    }

    public double calculateCost(double units) {
        return units * 8.0;
    }

    public String getName() {
        return name;
    }
}

// Fridge (No Saver Mode)
class Fridge extends Appliance {
    public Fridge() {
        super("FRIDGE", 150.0);
    }
}

// Air Conditioner (Supports Saver Mode)
class AirConditioner extends Appliance implements SaverMode {
    public AirConditioner() {
        super("AC", 1500.0);
    }
}

// Television (No Saver Mode)
class Television extends Appliance {
    public Television() {
        super("TV", 100.0);
    }
}

// Washing Machine (Supports Saver Mode)
class WashingMachine extends Appliance implements SaverMode {
    public WashingMachine() {
        super("WASHER", 500.0);
    }
}

// Main Driver Class
public class HomeApplianceEnergyReport {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) return;
        int n = Integer.parseInt(scanner.nextLine().trim());

        double totalCost = 0.0;

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) continue;

            String[] parts = line.split("\\s+");
            String applianceType = parts[0];
            double hours = Double.parseDouble(parts[1]);
            boolean isSaverRequested = (parts.length > 2 && parts[2].equalsIgnoreCase("SAVER"));

            Appliance appliance = null;

            switch (applianceType.toUpperCase()) {
                case "FRIDGE":
                    appliance = new Fridge();
                    break;
                case "AC":
                    appliance = new AirConditioner();
                    break;
                case "TV":
                    appliance = new Television();
                    break;
                case "WASHER":
                    appliance = new WashingMachine();
                    break;
            }

            if (appliance != null) {
                if (isSaverRequested && !(appliance instanceof SaverMode)) {
                    System.out.printf("%s: saver mode not supported%n", appliance.getName());
                } else {
                    double units = appliance.calculateUnits(hours);

                    if (isSaverRequested && appliance instanceof SaverMode) {
                        units = ((SaverMode) appliance).applySaverDiscount(units);
                    }

                    double cost = appliance.calculateCost(units);
                    totalCost += cost;

                    System.out.printf("%s: Units=%.2f Cost=%.2f%n", appliance.getName(), units, cost);
                }
            }
        }

        System.out.printf("Total Cost: %.2f%n", totalCost);
        scanner.close();
    }
}