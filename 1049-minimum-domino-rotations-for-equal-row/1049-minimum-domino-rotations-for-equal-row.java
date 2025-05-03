class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int n = tops.length;

        // Try both tops[0] and bottoms[0] as the target value.
        for (int target = 1; target <= 6; target++) {
            int topRotations = 0;
            int bottomRotations = 0;
            boolean possible = true;

            for (int i = 0; i < n; i++) {
                if (tops[i] != target && bottoms[i] != target) {
                    possible = false;
                    break;
                }
                if (tops[i] != target) {
                    topRotations++;  // Needs to swap the top half
                }
                if (bottoms[i] != target) {
                    bottomRotations++;  // Needs to swap the bottom half
                }
            }

            // If it's possible to make the entire row equal to target, return the minimum rotations.
            if (possible) {
                return Math.min(topRotations, bottomRotations);
            }
        }

        // If no target value can make all values in a row the same, return -1.
        return -1;
    }
}
