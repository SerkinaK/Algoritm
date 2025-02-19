package Алгоритмы;

import java.io.*;
import java.util.*;

public class LeftMedian108 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = reader.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int l = Integer.parseInt(firstLine[1]);
        List<List<Integer>> row = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] sequenceStr = reader.readLine().split(" ");
            List<Integer> sequence = new ArrayList<>();
            for (int j = 0; j < l; j++) {
                sequence.add(Integer.parseInt(sequenceStr[j]));
            }
            row.add(sequence);
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                List<Integer> mergedRow = new ArrayList<>();
                mergedRow.addAll(row.get(i));
                mergedRow.addAll(row.get(j));
                Collections.sort(mergedRow);
                System.out.println(mergedRow.get(l - 1));
            }
        }
    }
}

