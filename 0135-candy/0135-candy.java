class Solution {
    public int candy(int[] ratings) {
        int i = 1;
        int sum = 1;


        while(i < ratings.length){

            if(ratings[i] == ratings[i-1]){
                sum += 1;
                i++;
                continue;
            }

            int peak = 1;

            while(i < ratings.length && ratings[i] > ratings[i-1]){
                peak += 1;
                sum += peak;
                i++;
            }

            int down = 0;

            while(i < ratings.length && ratings[i] < ratings[i-1]){
                down +=1;
                sum += down;
                i++;
            }
            down+=1;
            if(down > peak){
                sum += down - peak;
            }
        }

        return sum;

    }
}