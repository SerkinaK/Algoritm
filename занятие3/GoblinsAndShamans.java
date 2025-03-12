package Algorithms.Lesson3;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class GoblinsAndShamans {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        Deque<Integer> left = new ArrayDeque<>();
        Deque<Integer> right = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            String[] query = reader.readLine().split(" ");
            switch (query[0]) {
                case "+":
                    int goblinId = Integer.parseInt(query[1]);
                    right.addLast(goblinId);
                    break;
                case "*":
                    goblinId = Integer.parseInt(query[1]);
                    right.addFirst(goblinId);
                    break;
                case "-":
                    writer.write(String.valueOf(left.removeFirst()));
                    writer.newLine();
                    break;
            }
            balanceQueues(left, right);
        }
        writer.flush();
        reader.close();
        writer.close();
    }
    private static void balanceQueues(Deque<Integer> left, Deque<Integer> right) {
        while (left.size() > right.size() + 1) {
            right.addFirst(left.removeLast());
        }
        while (right.size() > left.size()) {
            left.addLast(right.removeFirst());
        }
    }
}
