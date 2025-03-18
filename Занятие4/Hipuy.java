package Algorithms.Lesson4;

import java.util.*;

class Heap {
    private ArrayList<Integer> heap;

    public Heap() {
        heap = new ArrayList<>();
    }
    public void insert(int k) {
        heap.add(k);
        int i = heap.size() - 1;
        while (i > 0 && heap.get(i) > heap.get((i - 1) / 2)) {
            swap(i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }
    public int extractMax() {
        if (heap.isEmpty()) {
            return -1;
        }
        int max = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        heapify(0);
        return max;
    }
    private void heapify(int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < heap.size() && heap.get(left) > heap.get(largest)) {
            largest = left;
        }
        if (right < heap.size() && heap.get(right) > heap.get(largest)) {
            largest = right;
        }
        if (largest != i) {
            swap(i, largest);
            heapify(largest);
        }
    }
    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}
public class Hipuy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        Heap heap = new Heap();
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split(" ");
            int command = Integer.parseInt(parts[0]);

            if (command == 0) {
                int value = Integer.parseInt(parts[1]);
                heap.insert(value);
            } else if (command == 1) {
                System.out.println(heap.extractMax());
            }
        }
        scanner.close();
    }
}


