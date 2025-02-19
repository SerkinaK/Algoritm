package Алгоритмы;

import java.io.*;
import java.util.Arrays;

public class CodeRun83 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String[] strengthStr = reader.readLine().split(" ");
        int[] strength = new int[n];
        for (int i = 0; i < n; i++) {
            strength[i] = Integer.parseInt(strengthStr[i]);
        }
        int k = Integer.parseInt(reader.readLine());
        String[] pressStr = reader.readLine().split(" ");
        int[] press = new int[k];
        for (int i = 0; i < k; i++) {
            press[i] = Integer.parseInt(pressStr[i]);
        }
        boolean[] broken = new boolean[n];
        Arrays.fill(broken, false);

        for (int i = 0; i < k; i++) {
            int keyIndex = press[i] - 1;
            strength[keyIndex]--;

            if (strength[keyIndex] < 0) {
                broken[keyIndex] = true;
            }
        }
        for (int i = 0; i < n; i++) {
            if (broken[i]) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}

