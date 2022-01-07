class Solution {
    public String toLowerCase(String s) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            ans.append(c > 64 && c < 91 ? (char)(c + 32) : c);
        }
        return new String(ans);
    }
}