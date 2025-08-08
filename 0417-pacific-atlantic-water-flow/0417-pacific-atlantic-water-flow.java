class Solution {
    int rows, cols;
    int[][] heights;
    final int[][] DIRS = {{1,0},{-1,0},{0,1},{0,-1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        rows = heights.length;
        cols = heights[0].length;

        boolean[][] pac = new boolean[rows][cols];
        boolean[][] atl = new boolean[rows][cols];

        // Run DFS from all Pacific-border cells
        for (int c = 0; c < cols; c++) {
            dfs(0, c, pac, Integer.MIN_VALUE);
            dfs(rows-1, c, atl, Integer.MIN_VALUE);
        }
        for (int r = 0; r < rows; r++) {
            dfs(r, 0, pac, Integer.MIN_VALUE);
            dfs(r, cols-1, atl, Integer.MIN_VALUE);
        }

        // Collect cells reachable by both
        List<List<Integer>> result = new ArrayList<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (pac[r][c] && atl[r][c]) {
                    result.add(Arrays.asList(r, c));
                }
            }
        }
        return result;
    }

    private void dfs(int r, int c, boolean[][] visit, int prevHeight) {
        // Boundary, height, or already visited?
        if (r < 0 || c < 0 || r >= rows || c >= cols) return;
        if (visit[r][c]) return;
        if (heights[r][c] < prevHeight) return;

        visit[r][c] = true;
        for (int[] d : DIRS) {
            dfs(r + d[0], c + d[1], visit, heights[r][c]);
        }
    }
}
