class Solution {
    public int countServers(int[][] grid) {
        
        int res = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 1){
                   int val = dfs(i, j, grid);
                   res += val == 1 ? 0 : val;
                }
            }
        }

        return res;
    }

    public int dfs(int i, int j, int[][] grid){
        grid[i][j] = 0;
        int res = 1;

        for(int x = 0; x < grid.length; x++){
            if(grid[x][j] == 1){
                res+= dfs(x, j, grid);
            }
        }

        for(int x = 0; x < grid[0].length; x++){
            if(grid[i][x] == 1){
                res+= dfs(i, x, grid);
            }
        }

        return res;
    }
}