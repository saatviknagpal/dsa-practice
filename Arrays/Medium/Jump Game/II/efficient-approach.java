class Solution {
    public int jump(int[] nums) {
        int count = 0;
        int curr = -1;
        int next = 0;
        for(int i = 0; next < nums.length-1; i++){
            if (i > curr) {
                count++;
                curr = next;
            }
            next = Math.max(next, nums[i] + i);
        }
        return count;
    }
}
