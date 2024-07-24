class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ls = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int target = 0 - nums[i];
                int j = i + 1;
                int k = nums.length - 1;

                while (j < k) {
                    if (nums[j] + nums[k] == target) {
                        List<Integer> ms = new ArrayList<>();
                        ms.add(nums[i]);
                        ms.add(nums[j]);
                        ms.add(nums[k]);
                        ls.add(ms);
                        while (j < k && nums[j] == nums[j + 1]) {
                            j++;
                        }
                        while (j < k && nums[k] == nums[k - 1]) {
                            k--;
                        }
                        j++;
                        k--;
                    } else if (nums[j] + nums[k] < target) {
                        j++;
                    } else {
                        k--;
                    }
                }
            }
        }
        return ls;
    }
}