class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        if(nums.length <= 1){
            return Arrays.asList();
        }
        List<Integer> arr=new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i-1]){
                arr.add(nums[i]);
            }
        }
        return arr;
    }
}