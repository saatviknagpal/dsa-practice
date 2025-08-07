class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long count1 = 0;
        long count2 = 0;
        long sum1 = 0;
        long sum2 = 0;
        for(int num : nums1){
            if(num == 0) count1++;
            sum1 += num;
        }

        for(int num : nums2){
            if(num == 0) count2++;
            sum2+= num;
        }

        if(((sum1 + count1) < (sum2 + count2) && count1 == 0) || ((sum2 + count2) < (sum1 + count1) && count2 == 0)) return -1;
        return Math.max(sum1+count1, sum2+count2);
    }
}