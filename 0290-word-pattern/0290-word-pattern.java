class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character,String> map = new HashMap<>();
        int n = pattern.length();
        String arr[] = s.split(" ");
        if(n != arr.length) return false;
        for(int i=0;i<n;i++){
            char ch = pattern.charAt(i);
            if(map.containsKey(ch)){
                if(!map.get(ch).equals(arr[i])) return false;
            }
            else map.put(ch,arr[i]);
        }
        
        HashSet<String> set = new HashSet<>(map.values());

        if(set.size() != map.size()) return false;

        return true;
    }
}