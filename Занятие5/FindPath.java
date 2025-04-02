package Algorithms.Lesson5;

import java.util.ArrayList;

class FindPath {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        var matrix = new ArrayList<ArrayList<Integer>>(n);
        for (var i = 0; i<n;i++) {
            matrix.add(new ArrayList<Integer>());
        }
        for(var edge : edges){
            matrix.get(edge[0]).add(edge[1]);
            matrix.get(edge[1]).add(edge[0]);
        }
        var visited = new boolean [n];
        return DFS(source,destination,matrix, visited);
    }
    public boolean DFS(int cur, int destination, ArrayList<ArrayList<Integer>> matrix, boolean[] visited){
        visited[cur] = true;
        if (cur == destination){
            return true;
        }
        for (var i : matrix.get(cur)){
            if (!visited[i]){
                if (DFS(i,destination, matrix,visited)){
                    return true;
                }
            }
        }
        return false;
    }
}
