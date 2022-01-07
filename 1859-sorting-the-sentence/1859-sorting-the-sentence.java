class Solution {
    public String sortSentence(String s) {
        String array[] = s.split(" ");
        String temp[] = new String[array.length];
        String res = "";
        
        for(int i = 0; i < array.length; i++){
            int index = array[i].charAt(array[i].length()-1) - '0';
            temp[index-1] = array[i].substring(0, array[i].length()-1);
            
        }
        for(int i = 0; i < temp.length; i++){
            res+=temp[i];
            res+= " ";
        }
        return res.trim();
    }
}