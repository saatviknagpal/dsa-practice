class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int i,j;
        int sum = 0;
        for(i = 0; i < k; i++){
            sum = sum + cardPoints[i];
        }
        int maxSum = sum;
        for(j = cardPoints.length-1, i = k-1; j > (cardPoints.length-1)-k; j--, i--){
            sum -= cardPoints[i];
            sum += cardPoints[j];
            maxSum = Math.max(maxSum, sum); 
        }
        return maxSum;
    }
}