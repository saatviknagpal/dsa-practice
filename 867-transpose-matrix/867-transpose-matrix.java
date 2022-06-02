class Solution {
    public int[][] transpose(int[][] A) {
        int row = A.length, col = A[0].length;
        int[][] ans = new int[col][row];
        for (int r = 0; r < row; ++r)
            for (int c = 0; c < col; ++c) {
                ans[c][r] = A[r][c];
            }
        return ans;
    }
}