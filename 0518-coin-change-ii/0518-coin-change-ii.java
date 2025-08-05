class Solution {
    private int[][] memo;

    public int change(int amount, int[] coins) {
        memo = new int[coins.length][amount + 1];
        for (int i = 0; i < coins.length; i++)
            Arrays.fill(memo[i], -2);
        int res = dfs(0, coins, amount);
        return res;
    }

    public int dfs(int i, int[] coins, int amount) {
        if (amount == 0)
            return 1;

        if (i == coins.length)
            return 0;

        if (coins[i] > amount)
            return dfs(i + 1, coins, amount);
        if (memo[i][amount] != -2)
            return memo[i][amount];

        int take = dfs(i, coins, amount - coins[i]);

        int skip = dfs(i + 1, coins, amount);

        return memo[i][amount] = take + skip;
    }
}