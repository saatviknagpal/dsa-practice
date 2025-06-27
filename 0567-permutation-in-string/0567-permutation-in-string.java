class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] freq = new int[26];

        for(char x : s1.toCharArray()){
            freq[x-'a']++;
        }
        
        int i = 0;
        int j = s1.length()-1;

        while (j < s2.length()) {
            int[] temp = freq.clone(); 
            int k = i;
            while (k <= j) {
                temp[s2.charAt(k) - 'a']--;
                if (temp[s2.charAt(k) - 'a'] < 0) break; 
                k++;
            }
            if (k > j) return true;
            i++;
            j++;
        }

        return false;
    }
}

