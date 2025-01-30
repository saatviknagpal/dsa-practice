class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }

        int max = 0;
        
        for(int num : nums){
            
            if(set.remove(num)) {//num hasn't been visited
            int val = num;
            int sum = 1;
            while(set.remove(val-1)) val--;
            sum += num - val;
            
            val = num;
            while(set.remove(val+1)) val++;
            sum += val - num;
        
            max = Math.max(max, sum);
            }
        }

        return max;
    }
}