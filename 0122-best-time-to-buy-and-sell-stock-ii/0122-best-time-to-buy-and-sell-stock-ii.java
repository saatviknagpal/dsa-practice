class Solution {
    public int maxProfit(int[] nums) {
        int max = 0;

        for(int i = 1; i < nums.length; i++){
            if(nums[i] > nums[i-1]){
                max += Math.abs(nums[i] - nums[i-1]);
            }
        }

        return max;
    }
}