class Solution {
    private int[][] memo;

    public int coinChange(int[] coins, int amount) {
        memo = new int[coins.length][amount + 1];
        for (int i = 0; i < coins.length; i++)
            Arrays.fill(memo[i], -2);
        int res = dfs(0, coins, amount);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public int dfs(int i, int[] coins, int amount) {
        if (amount == 0)
            return 0;
        if (amount < 0)
            return Integer.MAX_VALUE;
        if (i == coins.length)
            return Integer.MAX_VALUE;

        if (memo[i][amount] != -2)
            return memo[i][amount];

        int take = dfs(i, coins, amount - coins[i]);
        if (take != Integer.MAX_VALUE)
            take += 1;
        int skip = dfs(i + 1, coins, amount);
        int best = Math.min(take, skip);
        memo[i][amount] = best;
        return best;
    }
}