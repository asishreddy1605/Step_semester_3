import java.util.Scanner;

// Interface for optional capability
interface Insurable {
    double calculateInsurance();
}

// Abstract Base Class for all Parcels
abstract class Parcel {
    protected double weight;
    protected double declaredValue;

    public Parcel(double weight, double declaredValue) {
        this.weight = weight;
        this.declaredValue = declaredValue;
    }

    public abstract double calculateShippingCharge();
    public abstract String getTypeName();
}

// Standard Parcel (Not Insurable)
class StandardParcel extends Parcel {
    public StandardParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    @Override
    public double calculateShippingCharge() {
        return 40.0 + (10.0 * weight);
    }

    @Override
    public String getTypeName() {
        return "STANDARD";
    }
}

// Express Parcel (Insurable)
class ExpressParcel extends Parcel implements Insurable {
    public ExpressParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    @Override
    public double calculateShippingCharge() {
        return 80.0 + (15.0 * weight);
    }

    @Override
    public double calculateInsurance() {
        return 0.02 * declaredValue;
    }

    @Override
    public String getTypeName() {
        return "EXPRESS";
    }
}

// Fragile Parcel (Insurable, extends Standard logic + handling fee)
class FragileParcel extends StandardParcel implements Insurable {
    public FragileParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    @Override
    public double calculateShippingCharge() {
        return super.calculateShippingCharge() + 50.0;
    }

    @Override
    public double calculateInsurance() {
        return 0.02 * declaredValue;
    }

    @Override
    public String getTypeName() {
        return "FRAGILE";
    }
}

// Main Driver Class
public class ParcelShippingDesk {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();

        double grandTotal = 0.0;

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double weight = scanner.nextDouble();
            double declaredValue = scanner.nextDouble();

            Parcel parcel = null;

            switch (type.toUpperCase()) {
                case "STANDARD":
                    parcel = new StandardParcel(weight, declaredValue);
                    break;
                case "EXPRESS":
                    parcel = new ExpressParcel(weight, declaredValue);
                    break;
                case "FRAGILE":
                    parcel = new FragileParcel(weight, declaredValue);
                    break;
            }

            if (parcel != null) {
                double charge = parcel.calculateShippingCharge();
                double insurance = (parcel instanceof Insurable) 
                        ? ((Insurable) parcel).calculateInsurance() 
                        : 0.00;
                double total = charge + insurance;

                grandTotal += total;

                System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                        parcel.getTypeName(), charge, insurance, total);
            }
        }

        System.out.printf("Grand Total: %.2f%n", grandTotal);
        scanner.close();
    }
}