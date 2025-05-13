package Algorithms.Lesson6;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class MostCommonWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> wordCount = new HashMap<>();
        while (scanner.hasNext()) {
            String word = scanner.next();
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        String mostCommonWord = null;
        int maxWord = 0;
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            String word = entry.getKey();
            int frequency = entry.getValue();
            if (frequency > maxWord ||
                    (frequency == maxWord && word.compareTo(mostCommonWord) < 0)) {
                mostCommonWord = word;
                maxWord = frequency;
            }
        }
        System.out.println(mostCommonWord);
    }
}