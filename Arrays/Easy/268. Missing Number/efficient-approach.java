class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += nums[i];
        }
        int actualsum = 0;
        for(int i = 0; i <= n; i++){
            actualsum += i;
        }
        int result = actualsum - sum;
        return result;
    }
}
