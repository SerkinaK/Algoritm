package Algorithms.Lesson6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

class Sells {
    public static void main(String[] args) throws IOException {
        Map<String, Map<String, Long>> salesData = new TreeMap<>(); 

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while ((line = br.readLine()) != null) {
            String[] parts = line.split(" ");
            String buyer = parts[0];
            String product = parts[1];
            long quantity = Long.parseLong(parts[2]);

            salesData.computeIfAbsent(buyer, k -> new TreeMap<>())
                    .compute(product, (k, v) -> (v == null) ? quantity : v + quantity);
        }

        br.close();

        StringBuilder output = new StringBuilder();

        for (Map.Entry<String, Map<String, Long>> buyerEntry : salesData.entrySet()) {
            String buyer = buyerEntry.getKey();
            output.append(buyer).append(":\n");

            Map<String, Long> productQuantities = buyerEntry.getValue();
            for (Map.Entry<String, Long> productEntry : productQuantities.entrySet()) {
                String product = productEntry.getKey();
                long quantity = productEntry.getValue();
                output.append(product).append(" ").append(quantity).append("\n");
            }
        }

        System.out.print(output.toString());
    }
}
