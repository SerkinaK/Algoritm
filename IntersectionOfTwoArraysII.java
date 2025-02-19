package Алгоритмы;

import java.util.ArrayList;
import java.util.Arrays;

class IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        ArrayList<Integer> res = new ArrayList<>();
        int left1 = 0;
        int left2 = 0;

        while (left1<nums1.length && left2<nums2.length){
            if (nums1[left1] == nums2[left2]){
                res.add(nums1[left1]);
                left1++;
                left2++;
            }
            else if (nums1[left1] < nums2[left2]){
                left1++;
            }
            else{
                left2++;
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}



