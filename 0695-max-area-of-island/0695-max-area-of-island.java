class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int maxArea = 0;

        for(int r = 0; r < row; r++){
            for(int c = 0; c < col; c++){
                if(grid[r][c] == 1){
                    int area = dfs(grid, r,c);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }

        return maxArea;
    }


    public int dfs(int[][] grid, int r, int c){
        int rows = grid.length;
        int cols = grid[0].length;

        if(r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] == 0){
            return 0;
        }

        grid[r][c] = 0;

        int area = 1;
        
        area += dfs(grid, r + 1, c);
        area += dfs(grid, r - 1, c);
        area += dfs(grid, r, c+1);
        area += dfs(grid, r, c-1);

        return area;
    }
}

