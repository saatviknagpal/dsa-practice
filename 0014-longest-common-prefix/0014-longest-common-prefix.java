class Solution {

    public String longestCommonPrefix(String[] S) {
        if (S.length == 0) return "";
        String prefix = S[0];
        for (int i = 1; i < S.length; i++) while (S[i].indexOf(prefix) != 0) {
            prefix = prefix.substring(0, prefix.length() - 1);
            if (prefix.isEmpty()) return "";
        }
        return prefix;
    }
}
