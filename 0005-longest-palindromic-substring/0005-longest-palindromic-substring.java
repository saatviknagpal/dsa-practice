class Solution {
    int[][] memo;

    public String longestPalindrome(String s) {
        int maxSoFar = 0;
        memo = new int[s.length()][s.length()];

        for (int[] row : memo)
            Arrays.fill(row, -1);

        int starting_point = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (solve(i, j, s)) {
                    int len = j - i + 1;
                    if (len > maxSoFar) {
                        maxSoFar = len;
                        starting_point = i;
                    }
                }
            }
        }

        return s.substring(starting_point, starting_point + maxSoFar);
    }

    public boolean solve(int i, int j, String s) {

        if (i >= j)
            return true;

        if (memo[i][j] != -1)
            return memo[i][j] == 1;

        if (s.charAt(i) != s.charAt(j)) {
            memo[i][j] = 0;
            return false;
        }

        boolean inner = solve(i + 1, j - 1, s);
        memo[i][j] = inner ? 1 : 0;
        return inner;
    }
}