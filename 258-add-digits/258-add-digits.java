class Solution {
    public int addDigits(int num) {
        int digit = 0;
        int sum = 0;
        if(num < 10){
            return num;
        }
        while(num/10 != 0){
            digit = num%10;
            num = num/10;
            sum = digit + num;
            if(sum >= 10){
                num = sum;
            }
        }
        return sum;
    }
}