class Solution {
    public int maxAdjacentDistance(int[] nums) {

        int max = Integer.MIN_VALUE;

        for(int i = 1; i < nums.length; i++){
            max = Math.max(max, Math.abs(nums[i-1] - nums[i]));
        }

        max = Math.max(max, Math.abs(nums[0] - nums[nums.length - 1]));

        return max;
    }
}