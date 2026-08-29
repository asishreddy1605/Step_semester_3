import java.util.*;

public class Q4_InventoryBalancer {

    public static void analyzeInventory(int[] sectionA, int[] sectionB) {
        int totalA = 0, totalB = 0;

        for (int val : sectionA) totalA += val;
        for (int val : sectionB) totalB += val;

        String status = (totalA == totalB) ? "Balanced" : "Not Balanced";

        int maxValue = Integer.MIN_VALUE;
        String maxSection = "";
        int maxIndex = -1;

        for (int i = 0; i < sectionA.length; i++) {
            if (sectionA[i] > maxValue) {
                maxValue = sectionA[i];
                maxSection = "Section A";
                maxIndex = i;
            }
        }

        for (int i = 0; i < sectionB.length; i++) {
            if (sectionB[i] > maxValue) {
                maxValue = sectionB[i];
                maxSection = "Section B";
                maxIndex = i;
            }
        }

        System.out.println("Section A Total: " + totalA +
                " | Section B Total: " + totalB +
                " | Status: " + status +
                " | Highest Quantity: " + maxValue +
                " (" + maxSection + ", Item " + (maxIndex + 1) + ")");
    }

    public static void main(String[] args) {
        analyzeInventory(new int[]{20, 15, 30}, new int[]{25, 10, 30});
    }
}