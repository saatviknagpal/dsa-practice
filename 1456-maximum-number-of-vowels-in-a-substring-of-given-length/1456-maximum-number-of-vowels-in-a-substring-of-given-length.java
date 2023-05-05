class Solution {

    public int maxVowels(String s, int k) {
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

        int ans = 0;
        for (int i = 0, count = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);

            if (set.contains(ch)) {
                count++;
            }

            if (i >= k && set.contains(s.charAt(i - k))) {
                --count;
            }

            ans = Math.max(count, ans);
        }

        return ans;
    }
}
