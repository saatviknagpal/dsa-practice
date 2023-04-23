class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            int prefixSumMod = prefixSum % k;
            if (prefixSumMod == 0 && i + 1 >= 2)
                return true;
            if (map.containsKey(prefixSumMod)) {
                if (i - map.get(prefixSumMod) >= 2)
                    return true;
            } else {
                map.put(prefixSumMod, i);
            }
        }
        return false;
    }
}