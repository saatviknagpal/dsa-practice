class Solution {
    public int findBestValue(int[] arr, int target) {
      Arrays.sort(arr);

        int left = 0; // Smallest possible value
        int right = arr[arr.length - 1]; // Largest possible value in the array
        int bestValue = 0;
        int closestDifference = Integer.MAX_VALUE;

        while (left <= right) {
            int mid = left + (right - left) / 2; // Middle point for binary search
            int sum = calculateSum(arr, mid);

            int difference = Math.abs(sum - target);

            // Update best value if this is closer, or same difference but smaller value
            if (difference < closestDifference || (difference == closestDifference && mid < bestValue)) {
                bestValue = mid;
                closestDifference = difference;
            }

            // Adjust the search range
            if (sum < target) {
                left = mid + 1; // Try larger values
            } else {
                right = mid - 1; // Try smaller values
            }
        }

        return bestValue;
    }

    private int calculateSum(int[] arr, int value) {
        int sum = 0;
        for (int num : arr) {
            sum += Math.min(num, value); // Replace numbers larger than `value` with `value`
        }
        return sum;
    }
}