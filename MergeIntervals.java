package Алгоритмы;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> merge = new ArrayList<>();
        for (int[] interval : intervals) {
            if (merge.isEmpty() || interval[0] > merge.get(merge.size() - 1)[1]) {
                merge.add(interval);
            } else {
                merge.get(merge.size() - 1)[1] = Math.max(merge.get(merge.size() - 1)[1], interval[1]);
            }
        }
        return merge.toArray(new int[merge.size()][]);

    }
}



