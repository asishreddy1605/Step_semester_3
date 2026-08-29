import java.util.Random;

public class BMICalculator {

    // Method to classify BMI
    public static String getBmiStatus(double bmi) {

        if (bmi < 18.5) {
            return "Underweight";
        } 
        else if (bmi < 25) {
            return "Normal";
        } 
        else if (bmi < 30) {
            return "Overweight";
        } 
        else {
            return "Obese";
        }
    }

    // Method to print wellness report
    public static void printWellnessReport(double[] heights, double[] weights) {

        System.out.println("\n================ WELLNESS REPORT ================");

        System.out.printf("%-10s %-15s %-15s %-10s %-15s%n",
                "Person", "Height (m)", "Weight (kg)", "BMI", "Status");

        System.out.println("---------------------------------------------------------------");

        for (int i = 0; i < heights.length; i++) {

            // Calculate BMI
            double bmi = weights[i] / (heights[i] * heights[i]);

            // Get BMI status
            String status = getBmiStatus(bmi);

            // Display details
            System.out.printf("%-10d %-15.2f %-15.2f %-10.2f %-15s%n",
                    (i + 1),
                    heights[i],
                    weights[i],
                    bmi,
                    status);
        }

        System.out.println("---------------------------------------------------------------");
    }

    public static void main(String[] args) {

        Random random = new Random();

        int n = 10;

        // Arrays for height and weight
        double[] heights = new double[n];
        double[] weights = new double[n];

        // Generate random height and weight
        for (int i = 0; i < n; i++) {

            // Height between 1.50 m and 1.90 m
            heights[i] = 1.50 + random.nextDouble() * 0.40;

            // Weight between 45 kg and 100 kg
            weights[i] = 45 + random.nextDouble() * 55;
        }

        // Print report
        printWellnessReport(heights, weights);
    }
}