class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int left = 0;
        int right = 0;
        int count = 0;
        int ans = -1;
        
        while(right < s.length()){
            count+= Math.abs(s.charAt(right) - t.charAt(right));
            
            while(count > maxCost){
                count-= Math.abs(s.charAt(left) - t.charAt(left));
                left++;
            }
            
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        
        return ans;
    }
}