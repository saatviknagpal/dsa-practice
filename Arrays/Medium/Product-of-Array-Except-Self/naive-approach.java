class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        int i, j;
        for(i = 1; i <= nums.length; i++){
            int mul = 1;
            for(j = nums.length-1; j >=0 ; j--){
                if(i-1!=j){
                    mul = mul * nums[j];
                    answer[i-1] = mul;
                }
            }
        }
        return answer;
    }
}