class Solution {

    public int numberOfSubarrays(int[] nums, int k) {
        int count = 0;
        int left = 0;
        int right = 0;
        int nice = 0;
        int temp = 0;

        while (right < nums.length) {
            if (nums[right] % 2 != 0) {
                nice++;
                temp = 0;
            }

            while (nice == k) {
                temp++;
                if (nums[left] % 2 != 0) nice--;
                left++;
            }
            count += temp;
            right++;
        }

        return count;
    }
}
