public class Solution {
    public int findKthNumber(int n, int k) {
        int curr = 1;
        k = k - 1; // since we already start from 1

        while (k > 0) {
            long steps = getCount(curr, curr + 1, n);
            if (steps <= k) {
                curr++;
                k -= steps;
            } else {
                curr *= 10;
                k -= 1;
            }
        }
        return curr;
    }

    public long getCount(long curr, long next, int n) {
        long count = 0;
        while (curr <= n) {
            count += Math.min(n + 1, next) - curr;
            curr *= 10;
            next *= 10;
        }
        return count;
    }
}
