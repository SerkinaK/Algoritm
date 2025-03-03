package Алгоритмы.Занятие3;

import java.io.*;
import java.util.Stack;

public class TrainSorting {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        String[] wagonNumbers = reader.readLine().split(" ");

        boolean possible = canSort(wagonNumbers);

        writer.write(possible ? "YES" : "NO");
        writer.newLine();
        writer.flush();

        reader.close();
        writer.close();
    }
    public static boolean canSort(String[] wagonNumbers) {
        Stack<Integer> siding = new Stack<>();
        int expectedWagon = 1;

        for (String wagonNumberStr : wagonNumbers) {
            int wagonNumber = Integer.parseInt(wagonNumberStr);
            while (!siding.isEmpty() && siding.peek() == expectedWagon) {
                siding.pop();
                expectedWagon++;
            }
            if (wagonNumber == expectedWagon) {
                expectedWagon++;
            } else if (!siding.isEmpty() && wagonNumber > siding.peek()) {
                return false;
            } else {
                siding.push(wagonNumber);
            }
        }
        while (!siding.isEmpty() && siding.peek() == expectedWagon) {
            siding.pop();
            expectedWagon++;
        }
        return siding.isEmpty();
    }
}

