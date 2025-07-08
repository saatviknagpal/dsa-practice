class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < piles.length; i++) {
            max = Math.max(max, piles[i]);
        }

        int low = 1;
        int high = max;
        int k = max; 

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int hours = 0;
            for (int i = 0; i < piles.length; i++) {
                hours += Math.ceil(piles[i] / (double)mid);
            }

            if (hours <= h) {
                k = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return k;
    }
}
