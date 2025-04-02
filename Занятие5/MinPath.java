package Algorithms.Lesson5;

import java.util.*;

public class MinPath {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] adjacencyMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                adjacencyMatrix[i][j] = scanner.nextInt();
            }
        }
        int startVertex = scanner.nextInt() - 1;
        int endVertex = scanner.nextInt() - 1;
        List<Integer> shortestPath = findShortestPath(adjacencyMatrix, startVertex, endVertex);
        if (shortestPath == null) {
            System.out.println(-1);
        } else if (startVertex == endVertex) {
            System.out.println(0);
            System.out.println(startVertex + 1);
        }
        else {
            System.out.println(shortestPath.size() - 1);
            for (int vertex : shortestPath) {
                System.out.print(vertex + 1 + " ");
            }
            System.out.println();
        }
    }
    public static List<Integer> findShortestPath(int[][] adjacencyMatrix, int startVertex, int endVertex) {
        int n = adjacencyMatrix.length;
        Queue<Integer> queue = new LinkedList<>();
        int[] distance = new int[n];
        int[] parent = new int[n];
        Arrays.fill(distance, -1);
        Arrays.fill(parent, -1);

        distance[startVertex] = 0;
        queue.offer(startVertex);
        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            if (currentVertex == endVertex) {
                break;
            }
            for (int neighbor = 0; neighbor < n; neighbor++) {
                if (adjacencyMatrix[currentVertex][neighbor] == 1 && distance[neighbor] == -1) {
                    distance[neighbor] = distance[currentVertex] + 1;
                    parent[neighbor] = currentVertex;
                    queue.offer(neighbor);
                }
            }
        }
        if (distance[endVertex] == -1) {
            return null;
        }
        List<Integer> path = new ArrayList<>();
        int current = endVertex;
        while (current != -1) {
            path.add(0, current);
            current = parent[current];
        }
        return path;
    }
}

