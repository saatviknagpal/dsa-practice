class Solution {
    public int memo[][];
    public int uniquePaths(int m, int n) {
        memo = new int[m][n];
        for(int i = 0; i < memo.length; i++){
            Arrays.fill(memo[i], -1);
        }
        int i = 0;
        int j = 0;
        return dfs(m, n, i, j);
    }

    public int dfs(int m, int n, int i, int j){
        if(i == (m - 1) && j == (n -1)){
            return 1;
        }
        if(i >= m || j >= n) return 0;

        if(memo[i][j] != -1) return memo[i][j];

        int down = dfs(m, n, i+1, j);
        int right = dfs(m, n, i, j + 1);

        int best = down + right;
        memo[i][j] = best;
        return best;
    }
}