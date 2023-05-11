class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int inc = 0;
        int ans = 0;
        
        for(int right = 0; right < nums.length; right++){
            
            if(nums[right] == 0) inc++;
            
            while(inc > k){
                
                if(nums[left] == 0) inc--;
                left++;
            }

            ans = Math.max(right - left + 1, ans);
        }
        
        return ans;
    }
}