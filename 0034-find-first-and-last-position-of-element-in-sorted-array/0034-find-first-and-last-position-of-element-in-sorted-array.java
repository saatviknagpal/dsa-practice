class Solution {

    public int[] searchRange(int[] nums, int target) {
        int firstIndex = helper(nums, target, false);
        int lastIndex = helper(nums, target, true);
        int []arr = new int[2];
        arr[0] = firstIndex;
        arr[1] = lastIndex;
        
        return arr;
    }

    public int helper(int[] nums, int target, boolean isLast) {
        int low = 0;
        int high = nums.length - 1;
        int index = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (!isLast) {
                if (nums[mid] >= target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (nums[mid] <= target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            if (nums[mid] == target) {
                index = mid;
            }
        }

        return index;
    }
}
