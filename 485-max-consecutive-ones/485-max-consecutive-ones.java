class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 1;
        int max = 0;
        int j = 1;
        
        if(nums.length <= 1){
            return nums[0];            
        }
        if(nums[0] + nums[1] == 0 && nums.length == 2){
            return 0;
        }
        for(int i = 0; i < nums.length-1; i++){
            if(nums[i] == 1 && nums[j] == 1){
                count++;
                j++;
            }
            else{
                count = 1;
                j++;
            }
            
            max = Math.max(count, max);
        }
        return max;
    }
}