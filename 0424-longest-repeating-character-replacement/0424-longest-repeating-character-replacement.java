class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int maxFreq = 0;
        int i = 0;
        int j = 0;

        while (j < s.length()) {
            freq[s.charAt(j) - 'A']++;
            maxFreq = Math.max(maxFreq, freq[s.charAt(j) - 'A']);
            int windowSize = j - i + 1;

            if (windowSize - maxFreq > k) {
                freq[s.charAt(i) - 'A']--;
                i++; 
            }
            j++;
        }

        return j-i;
    }
}