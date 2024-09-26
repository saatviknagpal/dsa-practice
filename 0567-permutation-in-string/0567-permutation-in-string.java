class Solution {
    public boolean checkInclusion(String s1, String s2) {

        int m = s1.length(), map[] = new int[26];        
        for (int i = 0; i < m; i++) map[s1.charAt(i)-'a']--;
        
        for (int i = 0, j = 0, len = 0; j < s2.length(); j++) {
            int k = s2.charAt(j)-'a';
            map[k]++;
            
            while (map[k] > 0) {                
                map[s2.charAt(i++)-'a']--;                    
            }    
                                                
            if (j-i+1 == m) return true;            
        }        
        return false;
    }
}