class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int sum = 0;
        int max = 0;
        Set<Integer> set = new HashSet<>();
        int i = 0; 
        int j = 0;
        while(i < nums.length && j < nums.length){
            if(!set.contains(nums[j])){
                sum+= nums[j];
                max = Math.max(sum, max);
                set.add(nums[j]);
                j++;
            }else{
                sum -= nums[i];
                set.remove(nums[i]);
                i++;
            }
        }
        return max;
    }
}