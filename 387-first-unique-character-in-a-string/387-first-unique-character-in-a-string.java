class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> ans = new HashMap<>();
        for (int i = 0; i < s.length(); i ++){
        char c = s.charAt(i);
        if(ans.containsKey(c)){
            ans.put(c,ans.get(c) + 1);
        }
        else{
            ans.put(c, 1);
        }
    }
    
    //return the first letter that has frequency of 1
    for (int i = 0; i < s.length(); i ++){
        char c = s.charAt(i);
        if (ans.get(c) == 1){
            return i;
        }
    }
    return -1;
       
    }
}