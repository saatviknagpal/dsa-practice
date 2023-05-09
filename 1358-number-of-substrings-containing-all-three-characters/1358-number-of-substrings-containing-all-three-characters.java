class Solution {

    public int numberOfSubstrings(String s) {
        int n = s.length();
        Map<Character, Integer> mp = new HashMap<>();
        int begin = 0, end = 0;
        int ans = 0;
        while (end < n) {
            char c = s.charAt(end);
            mp.put(c, mp.getOrDefault(c, 0) + 1);
            end++;
            while (mp.size() >= 3) {
                char pre = s.charAt(begin);
                mp.put(pre, mp.getOrDefault(pre, 0) - 1);
                if (mp.get(pre) == 0) {
                    mp.remove(pre);
                }
                ans += s.length() - end + 1;
                begin++;
            }
        }
        
        return ans;
    }
}
