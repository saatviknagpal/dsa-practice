class Solution {
    public boolean isPalindrome(int x) {
        String temp = Integer.toString(x);
        int i = 0;
        int j = temp.length() - 1;
        while(i < j){
            if(temp.charAt(i) == temp.charAt(j)){
                i++;
                j--;
            }
            else{
                return false;
            }
        }
        return true;
    }
}