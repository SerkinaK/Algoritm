package Алгоритмы;

class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int result = 0;
        while (left<= right){
            int mid = (left + right)/2;
            if (nums[mid]<target){
                result = mid + 1;
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return result;
    }
}

