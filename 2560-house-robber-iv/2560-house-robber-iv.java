class Solution {

    public int minCapability(int[] nums, int k) {
        int l = 1;
        int r = (int) 1e9;

        int ans = (int) 1e9;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            int n = nums.length;
            int count = 0;

            for (int i = 0; i < n; i++) {
                if (nums[i] <= mid) {
                    i++;
                    count++;
                }
            }

            if (count >= k) {
                ans = Math.min(ans, mid);
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return ans;
    }
}
