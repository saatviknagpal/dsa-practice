class Solution {

    public long minimumTime(int[] time, int totalTrips) {
        // Range based Binary Search

        long left = 1;

        long min = time[0];

        for (int t : time) {
            Math.min(min, t);
        }

        long right = totalTrips * min;

        while (left < right) {
            long mid = (left + right) / 2;
            long r = 0;
            for (int i : time) {
                if (i <= mid) {
                    r += mid / i;
                }
                if (r > totalTrips) break;
            }
            if (r < totalTrips) left = mid + 1; else right = mid;
        }
        return left;
    }
}
