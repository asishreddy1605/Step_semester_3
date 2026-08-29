import java.util.*;

public class Q3_TrafficSignalStreak {

    public static void findLongestStreak(String signalLog) {
        if (signalLog == null || signalLog.isEmpty()) {
            System.out.println("No signal data provided");
            return;
        }

        char longestChar = signalLog.charAt(0);
        int longestLength = 1;

        char currentChar = signalLog.charAt(0);
        int currentLength = 1;

        for (int i = 1; i < signalLog.length(); i++) {
            if (signalLog.charAt(i) == currentChar) {
                currentLength++;
            } else {
                currentChar = signalLog.charAt(i);
                currentLength = 1;
            }

            if (currentLength > longestLength) {
                longestLength = currentLength;
                longestChar = currentChar;
            }
        }

        System.out.println("Longest Streak: '" + longestChar + "' repeated " + longestLength + " times");
    }

    public static void main(String[] args) {
        findLongestStreak("RRGGGYRR");
        findLongestStreak("RRRRYYGG");
    }
}