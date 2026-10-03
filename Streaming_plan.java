import java.time.LocalDate;
import java.util.Scanner;

// Abstract Base Class
abstract class SubscriptionPlan {
    protected String name;
    protected LocalDate startDate;

    public SubscriptionPlan(String name, String startDateStr) {
        this.name = name;
        this.startDate = LocalDate.parse(startDateStr);
    }

    public String getName() {
        return name;
    }

    public abstract LocalDate getRenewalDate();
}

// Basic Plan Subclass: 30 Days Validity
class BasicPlan extends SubscriptionPlan {
    public BasicPlan(String name, String startDateStr) {
        super(name, startDateStr);
    }

    @Override
    public LocalDate getRenewalDate() {
        return startDate.plusDays(30);
    }
}

// Standard Plan Subclass: 90 Days Validity
class StandardPlan extends SubscriptionPlan {
    public StandardPlan(String name, String startDateStr) {
        super(name, startDateStr);
    }

    @Override
    public LocalDate getRenewalDate() {
        return startDate.plusDays(90);
    }
}

// Premium Plan Subclass: 365 Days Validity
class PremiumPlan extends SubscriptionPlan {
    public PremiumPlan(String name, String startDateStr) {
        super(name, startDateStr);
    }

    @Override
    public LocalDate getRenewalDate() {
        return startDate.plusDays(365);
    }
}

// Main Class
public class Streaming_plan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();

        SubscriptionPlan[] plans = new SubscriptionPlan[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            String startDateStr = sc.next();

            switch (type) {
                case "BASIC":
                    plans[i] = new BasicPlan(name, startDateStr);
                    break;
                case "STANDARD":
                    plans[i] = new StandardPlan(name, startDateStr);
                    break;
                case "PREMIUM":
                    plans[i] = new PremiumPlan(name, startDateStr);
                    break;
            }
        }

        // Processing using Polymorphism
        for (SubscriptionPlan plan : plans) {
            System.out.println(plan.getName() + ": " + plan.getRenewalDate());
        }

        sc.close();
    }
}