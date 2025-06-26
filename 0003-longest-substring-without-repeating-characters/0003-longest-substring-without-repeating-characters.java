class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();

        int max = s.length() > 0 ? 1 : 0;
        int i = 0;
        int j = 1;
        if (s.length() != 0)
            set.add(s.charAt(0));
        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
            } else {
                set.remove(s.charAt(i));
                i++;
            }
            max = Math.max(max, j - i);

        }

        return max;
    }
}