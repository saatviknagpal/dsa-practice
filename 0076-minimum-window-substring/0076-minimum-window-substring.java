class Solution {
    public String minWindow(String s, String t) {
        int[] freq = new int[128]; 

        for (char c : t.toCharArray()) {
            freq[c]++;
        }

        int left = 0, right = 0;
        int requiredCount = t.length();

        int minLen = Integer.MAX_VALUE;
        int start = 0;

        while (right < s.length()) {
            char c = s.charAt(right);

            if (freq[c] > 0) requiredCount--;
            freq[c]--;

            while (requiredCount == 0) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                char leftChar = s.charAt(left);
                freq[leftChar]++;
                if (freq[leftChar] > 0) {
                    requiredCount++;
                }
                left++;
            }

            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
