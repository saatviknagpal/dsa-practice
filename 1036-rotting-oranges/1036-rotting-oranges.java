class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length, i, j, k = 0, fresh = 0, fr;
        for (i = 0; i < m; i++)
            for (j = 0; j < n; j++)
                if (grid[i][j] == 1)
                    fresh++;
        while (fresh > 0) {
            fr = fresh;
            for (i = 0; i < m; i++) {
                for (j = 0; j < n; j++) {
                    if (grid[i][j] == 2) {
                        if (i + 1 < m && grid[i + 1][j] == 1) {
                            grid[i + 1][j] = 3;
                            fresh--;
                        }
                        if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                            grid[i - 1][j] = 3;
                            fresh--;
                        }
                        if (j - 1 >= 0 && grid[i][j - 1] == 1) {
                            grid[i][j - 1] = 3;
                            fresh--;
                        }
                        if (j + 1 < n && grid[i][j + 1] == 1) {
                            grid[i][j + 1] = 3;
                            fresh--;
                        }
                    }
                }
            }
            for (i = 0; i < m; i++)
                for (j = 0; j < n; j++)
                    if (grid[i][j] == 3)
                        grid[i][j] = 2;
            if (fr == fresh)
                return -1;
            k++;
        }
        return k;
    }
}