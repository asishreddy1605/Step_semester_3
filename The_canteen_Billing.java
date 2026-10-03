import java.util.Scanner;

// Abstract Base Class
abstract class Customer {
    protected double amount;

    public Customer(double amount) {
        this.amount = amount;
    }

    public abstract double calculateFinalAmount();
    public abstract String getCustomerType();
}

// Student Subclass: 10% Discount
class StudentCustomer extends Customer {
    public StudentCustomer(double amount) {
        super(amount);
    }

    @Override
    public double calculateFinalAmount() {
        return amount * 0.90;
    }

    @Override
    public String getCustomerType() {
        return "STUDENT";
    }
}

// Staff Subclass: 5% Discount
class StaffCustomer extends Customer {
    public StaffCustomer(double amount) {
        super(amount);
    }

    @Override
    public double calculateFinalAmount() {
        return amount * 0.95;
    }

    @Override
    public String getCustomerType() {
        return "STAFF";
    }
}

// Guest Subclass: Base Amount + ₹10 Service Charge
class GuestCustomer extends Customer {
    public GuestCustomer(double amount) {
        super(amount);
    }

    @Override
    public double calculateFinalAmount() {
        return amount + 10.0;
    }

    @Override
    public String getCustomerType() {
        return "GUEST";
    }
}

// Main Class
public class The_canteen_Billing  {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        
        Customer[] customers = new Customer[n];
        double grandTotal = 0.0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();

            switch (type) {
                case "STUDENT":
                    customers[i] = new StudentCustomer(amount);
                    break;
                case "STAFF":
                    customers[i] = new StaffCustomer(amount);
                    break;
                case "GUEST":
                    customers[i] = new GuestCustomer(amount);
                    break;
            }
        }

        // Processing using Polymorphism (No type-checking during display)
        for (Customer customer : customers) {
            double finalAmount = customer.calculateFinalAmount();
            System.out.printf("%s: %.2f%n", customer.getCustomerType(), finalAmount);
            grandTotal += finalAmount;
        }

        System.out.printf("Total: %.2f%n", grandTotal);
        
        sc.close();
    }
}