import java.util.*;

public class Q2_TypingAccuracy {

    public static void checkTypingAccuracy(String original, String typed) {
        if (original.length() != typed.length()) {
            System.out.println("Error: Strings must be of equal length");
            return;
        }

        int total = original.length();
        int matched = 0;
        int firstMismatchPos = -1;

        for (int i = 0; i < total; i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else if (firstMismatchPos == -1) {
                firstMismatchPos = i;
            }
        }

        double accuracy = ((double) matched / total) * 100;

        StringBuilder result = new StringBuilder();
        result.append("Matched: ").append(matched).append("/").append(total)
              .append(" | Accuracy: ").append(String.format("%.2f", accuracy)).append("%");

        if (firstMismatchPos == -1) {
            result.append(" | No Mismatches");
        } else {
            result.append(" | First Mismatch at position ").append(firstMismatchPos + 1)
                  .append(" ('").append(original.charAt(firstMismatchPos)).append("' vs '")
                  .append(typed.charAt(firstMismatchPos)).append("')");
        }

        System.out.println(result);
    }

    public static void main(String[] args) {
        checkTypingAccuracy("hello world", "hello worlt");
        checkTypingAccuracy("coding", "coding");
    }
}