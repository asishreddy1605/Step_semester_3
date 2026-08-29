import java.util.*;

public class Q5_WordLengthProfiler {

    public static void classifyWordLengths(String review) {
        String[] words = review.trim().split("\\\\s+");

        int shortCount = 0, mediumCount = 0, longCount = 0;

        for (String word : words) {
            String cleaned = word.replaceAll("[^a-zA-Z]", "");

            if (cleaned.isEmpty()) continue;

            int len = cleaned.length();

            if (len <= 4) {
                shortCount++;
            } else if (len <= 8) {
                mediumCount++;
            } else {
                longCount++;
            }
        }

        System.out.println("Short: " + shortCount +
                " | Medium: " + mediumCount +
                " | Long: " + longCount);
    }

    public static void main(String[] args) {
        classifyWordLengths("This movie was absolutely fantastic and thrilling");
    }
}