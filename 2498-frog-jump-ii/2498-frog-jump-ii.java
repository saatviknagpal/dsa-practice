class Solution {

    public int maxJump(int[] stones) {
        int min = stones[stones.length - 1] - stones[0];
        int ans = 0;
        int low = 0;
        int high = stones[stones.length - 1];

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isPossible(mid, stones)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    public boolean isPossible(int k, int stones[]) {
        Set<Integer> set = new HashSet<>();
        int last = 0;
        for (int i = 1; i < stones.length; i++) {
            if (stones[i] - stones[last] > k) {
                if (i - last > 1) {
                    set.add(i - 1);
                    last = i - 1;
                    i--;
                } else {
                    return false;
                }
            }
        }
        last = stones.length - 1;
        for (int i = stones.length - 2; i >= 0; i--) {
            if (set.contains(i) == false) {
                if (stones[last] - stones[i] > k) {
                    return false;
                } else {
                    last = i;
                }
            }
        }
        return true;
    }
}
