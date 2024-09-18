class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        int left = 0;
        int right = 0;

        while (right < k) {
            sum += nums[right];
            right++;
        }

        double max = sum / k;

        while (right < nums.length) {
            sum += nums[right] - nums[left];
            max = Math.max(max, sum / k);
            left++;
            right++;
        }

        return max;
    }
}
