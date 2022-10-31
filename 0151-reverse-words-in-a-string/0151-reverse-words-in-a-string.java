class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        StringBuilder word = new StringBuilder();
        
        
        for(int i = s.length() - 1; i >= 0; i--){
            if(s.charAt(i) == ' ' && word.length() != 0){
                sb.append(" " + word);
                word = new StringBuilder();
            } else if(s.charAt(i) != ' '){
                word.insert(0, s.charAt(i));
            }
        }
        sb.append(" " + word);
        return sb.toString().trim();
    }

}