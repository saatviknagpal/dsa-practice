class Solution {
    List<String> result = new ArrayList<>();

    public void solve(StringBuilder curr, int n, int open, int close) {
        if (curr.length() == 2 * n) {
            result.add(curr.toString());  // Convert StringBuilder to String
            return;
        }

        if (open < n) {
            curr.append("(");
            solve(curr, n, open + 1, close);
            curr.deleteCharAt(curr.length() - 1);  // backtrack
        }

        if (close < open) {
            curr.append(")");
            solve(curr, n, open, close + 1);
            curr.deleteCharAt(curr.length() - 1);  // backtrack
        }
    }

    public List<String> generateParenthesis(int n) {
        StringBuilder curr = new StringBuilder();
        solve(curr, n, 0, 0);
        return result;
    }
}
