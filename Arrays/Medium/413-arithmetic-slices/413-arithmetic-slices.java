class Solution {

    public int numberOfArithmeticSlices(int[] nums) {
        int c = 0;
        if (nums.length < 3) return 0; else {
            for (int i = 0; i < nums.length; i++) {
                for (int j = i; j < nums.length - 2; j++) {
                    if (nums[j] - nums[j + 1] == nums[j + 1] - nums[j + 2]) c++; else break;
                }
            }
        }
        return c;
    }
}
