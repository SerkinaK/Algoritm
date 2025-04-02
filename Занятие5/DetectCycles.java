package Algorithms.Lesson5;

import java.util.*;

public class DetectCycles {

    private static int n;
    private static int[][] adjMatrix;
    private static boolean[] visited;
    private static int[] parent;
    private static List<Integer> cycle;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        scanner.nextLine();

        adjMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] row = scanner.nextLine().split(" ");
            for (int j = 0; j < n; j++) {
                adjMatrix[i][j] = Integer.parseInt(row[j]);
            }
        }
        visited = new boolean[n];
        parent = new int[n];
        Arrays.fill(parent, -1);
        cycle = null;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (dfs(i, -1)) {
                    break;
                }
            }
        }
        if (cycle == null) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
            System.out.println(cycle.size());
            for (int i = 0; i < cycle.size(); i++) {
                System.out.print(cycle.get(i) + 1);
                if (i < cycle.size() - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    private static boolean dfs(int u, int par) {
        visited[u] = true;
        parent[u] = par;
        for (int v = 0; v < n; v++) {
            if (adjMatrix[u][v] == 1) {
                if (!visited[v]) {
                    if (dfs(v, u)) {
                        return true;
                    }
                } else if (v != par && parent[u] != v ) {
                    cycle = new ArrayList<>();
                    int current = u;
                    cycle.add(v);
                    while (current != v) {
                        cycle.add(current);
                        current = parent[current];
                    }
                    return true;
                }
            }
        }
        return false;
    }
}
