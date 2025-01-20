class Solution {
    int[][] memo;
    int MOD = 1_000_000_007;

    public int numRollsToTarget(int n, int k, int target) {
        memo = new int[n + 1][target + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                memo[i][j] = -1;
            }
        }

        return solve(n, k, target);
    }

    public int solve(int n, int k, int target) {
        if (n == 0)
            return target == 0 ? 1 : 0;
        if (target < 0)
            return 0;
        if (memo[n][target] != -1)
            return memo[n][target];

        int ways = 0;

        for (int face = 1; face <= k; face++) {
            ways = (ways + solve(n - 1, k, target - face)) % MOD;
        }
        return memo[n][target] = ways;
    }
}