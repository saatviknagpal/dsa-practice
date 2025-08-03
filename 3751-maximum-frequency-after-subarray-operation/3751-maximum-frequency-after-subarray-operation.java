
class Solution {
    public static int solve(int[] nums, int k) {
        int k_freq = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        if (map.containsKey(k)) {
            k_freq += map.get(k);
        }
        
        int max = 0;
        
        for (int v = 1; v <= 50; v++) {
            if (v == k) continue;            
            int curr_sum = 0;
            int temp_max = 0;
            for (int num : nums) {
                if (num == v) {
                    curr_sum += 1;
                } else if (num == k) {
                    curr_sum -= 1;
                }

                if (curr_sum < 0) {
                    curr_sum = 0;
                }

                if (curr_sum > temp_max) {
                    temp_max = curr_sum;
                }
            }

            if (temp_max > max) {
                max = temp_max;
            }
        }

        int maxfreq = k_freq + max;
        return maxfreq;
    }

    public int maxFrequency(int[] nums, int k) {
        return solve(nums, k);
    }
}