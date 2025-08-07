class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        boolean result = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == word.charAt(0)) {      
                    if (dfs(board, i, j, n, m, word, 0)) { 
                        return true;                       
                    }
                }
            }
        }
        return false;  
    }

    public int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public boolean dfs(char[][] board, int i, int j, int n, int m, String word, int idx) {
        if (idx == word.length())    
            return true;
        if (i < 0 || j < 0 || i >= n || j >= m
            || board[i][j] != word.charAt(idx))  
            return false;

        char save = board[i][j];       
        board[i][j] = '#';            

        for (int[] dir : directions) {
            int new_i = i + dir[0], new_j = j + dir[1];
            if (dfs(board, new_i, new_j, n, m, word, idx + 1)) {
                board[i][j] = save;  
                return true;
            }
        }

        board[i][j] = save;          
        return false;                
    }
}
