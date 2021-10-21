//O(N^2) Time Complexity


class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            int quotient = 0;
            while(nums[i] >= 10){
                nums[i] = nums[i]/10;
                quotient++;
            }
            if(quotient%2 != 0){
                count++;
            }
        }
        return count;
    }
}
