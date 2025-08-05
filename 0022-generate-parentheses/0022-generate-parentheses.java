class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        int open = 0;
        int close = 0;
        StringBuilder sb = new StringBuilder();
        helper(result, n, open, close, sb);

        return result;
    }

    public void helper(List<String> result, int n, int open, int close, StringBuilder sb){
        if(open == n && close == n){
            result.add(sb.toString());
            return;
        }

        if(open < n){
            sb.append('(');
            helper(result, n, open + 1, close, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

        if(close < open){
            sb.append(')');
            helper(result, n, open, close + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }


}
