class Solution {
    public int findNumbers(int[] nums) {
        int evenCount = 0;
        if (nums.length == 0) return evenCount;
        for (int num : nums) {
            String stringNum = Integer.toString(num);
            if (stringNum.length() % 2 == 0) {
                evenCount++;
            }
        }
        return evenCount;
    }
}
