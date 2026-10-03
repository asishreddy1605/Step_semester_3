import java.util.Scanner;

// Abstract Base Class
abstract class Employee {
    protected String name;
    protected double monthlySalary;

    public Employee(String name, double monthlySalary) {
        this.name = name;
        this.monthlySalary = monthlySalary;
    }

    public String getName() {
        return name;
    }

    public abstract double calculateBonus();
}

// Full-Time Subclass: 10% of monthly salary
class FullTimeEmployee extends Employee {
    public FullTimeEmployee(String name, double monthlySalary) {
        super(name, monthlySalary);
    }

    @Override
    public double calculateBonus() {
        return monthlySalary * 0.10;
    }
}

// Part-Time Subclass: 5% of monthly salary
class PartTimeEmployee extends Employee {
    public PartTimeEmployee(String name, double monthlySalary) {
        super(name, monthlySalary);
    }

    @Override
    public double calculateBonus() {
        return monthlySalary * 0.05;
    }
}

// Intern Subclass: Fixed bonus of ₹2000
class InternEmployee extends Employee {
    public InternEmployee(String name, double monthlySalary) {
        super(name, monthlySalary);
    }

    @Override
    public double calculateBonus() {
        return 2000.0;
    }
}

// Main Class
public class Festival_Bonus_calculater {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();

        Employee[] employees = new Employee[n];
        double totalBonus = 0.0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();

            switch (type) {
                case "FULLTIME":
                    employees[i] = new FullTimeEmployee(name, salary);
                    break;
                case "PARTTIME":
                    employees[i] = new PartTimeEmployee(name, salary);
                    break;
                case "INTERN":
                    employees[i] = new InternEmployee(name, salary);
                    break;
            }
        }

        // Processing using Polymorphism
        for (Employee emp : employees) {
            double bonus = emp.calculateBonus();
            System.out.printf("%s: %.2f%n", emp.getName(), bonus);
            totalBonus += bonus;
        }

        System.out.printf("Total Bonus: %.2f%n", totalBonus);

        sc.close();
    }
}