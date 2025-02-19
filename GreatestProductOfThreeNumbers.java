package Алгоритмы;

import java.io.*;
import java.util.Arrays;

class GreatestProductOfThreeNumbers {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String line = reader.readLine();

        String[] numsStr = line.split(" ");
        int len = numsStr.length;
        if (len < 3) {
            writer.newLine();
            writer.close();
            return;
        }
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = Integer.parseInt(numsStr[i]);
        }
        Arrays.sort(nums);
        int n = nums.length;
        long multi1 = (long)nums[n - 1] * nums[n - 2] * nums[n - 3];
        long multi2 = (long)nums[0] * nums[1] * nums[n - 1];
        int[] result;
        if (multi1 >= multi2) {
            result = new int[]{nums[n - 1], nums[n - 2], nums[n - 3]};
        } else {
            result = new int[]{nums[0], nums[1], nums[n - 1]};
        }
        for (int i = 0; i < result.length; i++) {
            writer.write(String.valueOf(result[i]));
            if (i < result.length - 1) {
                writer.write(" ");
            }
        }
        writer.newLine();
        reader.close();
        writer.close();
    }
}

