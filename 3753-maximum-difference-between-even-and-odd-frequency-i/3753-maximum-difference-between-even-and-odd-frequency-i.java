class Solution {
    public int maxDifference(String s) {
        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++; 
        }
        

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < freq.length; i++){
            if(freq[i] == 0) continue;
            if(max < freq[i] && freq[i] % 2 != 0) max = freq[i];
            if(min > freq[i] && freq[i] % 2 == 0) min = freq[i];
        }

        return max - min;
    }
}