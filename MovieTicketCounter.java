import java.util.Scanner;

// Abstract Base Class
abstract class Ticket {
    protected String seatType;
    protected int count;
    protected static final double CONVENIENCE_FEE = 20.00;

    public Ticket(String seatType, int count) {
        this.seatType = seatType;
        this.count = count;
    }

    // Abstract method for seat-specific base price
    public abstract double getBasePricePerTicket();

    // Shared calculation logic written in one place
    public double calculateTotalAmount() {
        return (getBasePricePerTicket() + CONVENIENCE_FEE) * count;
    }

    public String getSeatType() {
        return seatType;
    }
}

// Subclass for Regular Seat
class RegularTicket extends Ticket {
    public RegularTicket(int count) {
        super("REGULAR", count);
    }

    @Override
    public double getBasePricePerTicket() {
        return 150.00;
    }
}

// Subclass for Premium Seat
class PremiumTicket extends Ticket {
    public PremiumTicket(int count) {
        super("PREMIUM", count);
    }

    @Override
    public double getBasePricePerTicket() {
        return 250.00;
    }
}

// Subclass for Recliner Seat
class ReclinerTicket extends Ticket {
    public ReclinerTicket(int count) {
        super("RECLINER", count);
    }

    @Override
    public double getBasePricePerTicket() {
        return 400.00;
    }
}

// Main Driver Class
public class MovieTicketCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();

        double totalCollected = 0.0;

        for (int i = 0; i < n; i++) {
            String seatType = scanner.next();
            int count = scanner.nextInt();

            Ticket ticket = null;

            switch (seatType.toUpperCase()) {
                case "REGULAR":
                    ticket = new RegularTicket(count);
                    break;
                case "PREMIUM":
                    ticket = new PremiumTicket(count);
                    break;
                case "RECLINER":
                    ticket = new ReclinerTicket(count);
                    break;
            }

            if (ticket != null) {
                double bookingAmount = ticket.calculateTotalAmount();
                totalCollected += bookingAmount;
                System.out.printf("%s: %.2f%n", ticket.getSeatType(), bookingAmount);
            }
        }

        System.out.printf("Total: %.2f%n", totalCollected);
        scanner.close();
    }
}