class Solution {

    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int right = 0;

        int inc = 0;
        int ans = 0;

        while (right < nums.length) {
            if (nums[right] == 0) inc++;

            while (inc > k) {
                if (nums[left] == 0) inc--;
                left++;
            }

            ans = Math.max(right - left + 1, ans);
            right++;
        }

        return ans;
    }
}
