//O(N) Time
//O(N) Space

class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] ans = new int[101];
        for(int i = 0; i<nums.length; i++){
            ans[nums[i]]++;
        }
        for(int i = 1; i< 101; i++){
            ans[i]+= ans[i-1];
        }
        for(int i = 0; i<nums.length; i++){
            if(nums[i] == 0){
                nums[i] = 0;
            }
            else{
            nums[i] = ans[nums[i]-1];
            }
        }
        return nums;
    }
}
