import java.util.HashMap;
import java.util.Map;
public class StopWordFilteredWordFrequency {
    public static void printFilteredWordFrequency(String feedback) {
        String[] stopWords = {"the", "was", "and", "a", "is", "of", "in"};
        String cleanedText = feedback.toLowerCase()
                .replace(".", "")
                .replace(",", "");
        String[] words = cleanedText.split("\\s+");
        HashMap<String, Integer> frequency = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            boolean isStopWord = false;
            for (int j = 0; j < stopWords.length; j++) {
                if (words[i].equals(stopWords[j])) {
                    isStopWord = true;
                    break;
                }
            }
            if (!isStopWord) {
                frequency.put(words[i], frequency.getOrDefault(words[i], 0) + 1);
            }
        }
        frequency.entrySet()
                .stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .forEach(entry ->
                        System.out.println(entry.getKey() + ": " + entry.getValue()));
    }
    public static void main(String[] args) {
        String feedback = "The mentor was great, the session was great and clear.";
        printFilteredWordFrequency(feedback);
    }
}