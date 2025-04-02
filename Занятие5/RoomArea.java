package Algorithms.Lesson5;

import java.util.Scanner;

public class RoomArea {
    static int n;
    static char[][] maze;
    static boolean[][] visited;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        scanner.nextLine();
        maze = new char[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            maze[i] = scanner.nextLine().toCharArray();
        }
        int startRow = scanner.nextInt() - 1;
        int startCol = scanner.nextInt() - 1;
        System.out.println(calculateRoomArea(startRow, startCol));
    }
    static int calculateRoomArea(int row, int col) {
        if (row < 0 || row >= n || col < 0 || col >= n || maze[row][col] == '*' || visited[row][col]) {
            return 0;
        }
        visited[row][col] = true;
        return 1 + calculateRoomArea(row + 1, col) +
                calculateRoomArea(row - 1, col) +
                calculateRoomArea(row, col + 1) +
                calculateRoomArea(row, col - 1);
    }
}

