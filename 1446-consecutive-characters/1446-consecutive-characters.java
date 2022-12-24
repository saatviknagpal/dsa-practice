class Solution {
    public int maxPower(String str) {
        int counter = 1;
        int max = 1;
        for(int i = 1; i < str.length(); i++){
            if(str.charAt(i) == str.charAt(i-1)){
                counter++;
                max = Math.max(counter,max);
            } else{
                counter = 1;
            }
        }
        return max;
    }
}