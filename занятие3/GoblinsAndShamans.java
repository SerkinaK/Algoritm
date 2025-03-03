package Algorithms.Lesson3;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class GoblinsAndShamans {
    public static void main (String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        Deque<Integer> queue = new ArrayDeque<>();
        int mid = 0;
        for (int i = 0; i < n; i++) {
            String[] query = reader.readLine().split(" ");
            switch (query[0]) {
                case "+":
                    int goblinId = Integer.parseInt(query[1]);
                    queue.addLast(goblinId);
                    if (queue.size() % 2 != 0) {
                        mid = (queue.size() + 1) / 2;
                    }
                    break;
                case "*":
                    goblinId = Integer.parseInt(query[1]);
                    if (queue.isEmpty()) {
                        queue.addFirst(goblinId);
                        mid = 1;
                    } else {
                        Deque<Integer> tempQueue = new ArrayDeque<>();
                        int count = 0;
                        while (count < queue.size() - mid) {
                            tempQueue.addFirst(queue.removeLast());
                            count++;
                        }
                        queue.addLast(goblinId);
                        while (!tempQueue.isEmpty()) {
                            queue.addLast(tempQueue.removeFirst());
                        }
                        if (queue.size() % 2 == 0) {
                            mid = (queue.size() + 1) / 2;
                        } else {
                            mid = (queue.size() + 1) / 2;
                        }
                    }
                    break;
                case "-":
                    int removedGoblin = queue.removeFirst();
                    writer.write(String.valueOf(removedGoblin));
                    writer.newLine();
                    if (queue.size() % 2 == 0) {
                        mid = (queue.size() + 1) / 2;
                    } else if (queue.size() > 0){
                        mid = (queue.size() + 1) / 2;
                    }
                    break;
            }
        }
        writer.flush();
        reader.close();
        writer.close();
    }
}
