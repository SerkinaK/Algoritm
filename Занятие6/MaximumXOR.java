package Algorithms.Lesson6;

import java.util.HashSet;
import java.util.Set;

class MaximumXOR {
    public int findMaximumXOR(int[] nums) {
        int max = 0;
        int mask = 0;
        for (int i = 31; i >= 0; i--) {
            mask |= (1 << i);
            Set<Integer> prefixes = new HashSet<>();
            for (int num : nums) {
                prefixes.add(num & mask);
            }
            int nextMax = max | (1 << i);
            for (int prefix : prefixes) {
                if (prefixes.contains(prefix ^ nextMax)) {
                    max = nextMax;
                    break;
                }
            }
        }
        return max;
    }
}

