class Solution {

    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        int n = nums.length / 3;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        for (Integer i : map.keySet()) {
            if (map.get(i) > n) result.add(i);
        }
        return result;
    }
}
