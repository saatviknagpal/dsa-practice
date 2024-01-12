class Solution {
    public boolean halvesAreAlike(String s) {
        String a = s.substring(0,s.length()/2);
        String b = s.substring(s.length()/2);
        String vowels = "AEIOUaeiou";
        int count1 = 0;
        int count2 = 0;
        
        for(int i = 0; i < a.length(); i++){
            if(vowels.indexOf(a.charAt(i)) >= 0){
                count1++;
            }
            if(vowels.indexOf(b.charAt(i)) >= 0){
                count2++;
            }
        }
        return count1 == count2;
    }
}