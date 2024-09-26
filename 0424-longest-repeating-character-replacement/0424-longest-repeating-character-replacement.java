class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];

        int freqLetter = 0;
        int left = 0;

        int max = 0;

        for(int right = 0; right < s.length(); right++){
            freq[s.charAt(right) - 'A']++;
            freqLetter = Math.max(freqLetter, freq[s.charAt(right) - 'A']);

            int change = (right - left + 1) - freqLetter;

            if(change > k){
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            max = Math.max(max, right - left + 1);
        }
        return max;

    }
}