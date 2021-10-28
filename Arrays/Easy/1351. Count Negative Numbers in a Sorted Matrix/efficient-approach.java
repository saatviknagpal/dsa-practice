//Time : O(M+N)

class Solution {
    public int countNegatives(int[][] grid) {
        int N = grid.length, row = N - 1, col = 0, M = grid[0].length, count = 0;
        
        while(row >= 0 && col < M){
            if(grid[row][col] < 0){
                count += M - col;
                row--;
            }else{
                col++;
            }
        }
        
        return count;
    }
}
