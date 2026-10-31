import java.util.Scanner;

// Capability Interface for students using the transport service
interface TransportUser {
    default double getTransportFee() {
        return 12000.00;
    }
}

// Abstract Base Class for all Students
abstract class Student {
    protected String name;

    public Student(String name) {
        this.name = name;
    }

    public abstract double getTuitionFee();

    public double calculateTotalFee() {
        double fee = getTuitionFee();
        if (this instanceof TransportUser) {
            fee += ((TransportUser) this).getTransportFee();
        }
        return fee;
    }

    public String getName() {
        return name;
    }
}

// Day Scholar Student (Uses Transport)
class DayScholar extends Student implements TransportUser {
    public DayScholar(String name) {
        super(name);
    }

    @Override
    public double getTuitionFee() {
        return 40000.00;
    }
}

// Hosteller Student (Does NOT use Transport)
class Hosteller extends Student {
    public Hosteller(String name) {
        super(name);
    }

    @Override
    public double getTuitionFee() {
        return 40000.00 + 60000.00; // Tuition + Hostel Fee
    }
}

// Scholarship Student (Uses Transport, 50% Tuition)
class ScholarshipStudent extends Student implements TransportUser {
    public ScholarshipStudent(String name) {
        super(name);
    }

    @Override
    public double getTuitionFee() {
        return 20000.00; // Half tuition
    }
}

// Main Driver Class
public class CollegeFeeCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();

        double totalCollected = 0.0;

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.next();

            Student student = null;

            switch (type.toUpperCase()) {
                case "DAY_SCHOLAR":
                    student = new DayScholar(name);
                    break;
                case "HOSTELLER":
                    student = new Hosteller(name);
                    break;
                case "SCHOLAR":
                    student = new ScholarshipStudent(name);
                    break;
            }

            if (student != null) {
                double studentFee = student.calculateTotalFee();
                totalCollected += studentFee;
                System.out.printf("%s: %.2f%n", student.getName(), studentFee);
            }
        }

        System.out.printf("Total Collected: %.2f%n", totalCollected);
        scanner.close();
    }
}