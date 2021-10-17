class Solution {
    public int maximumWealth(int[][] accounts) {
        int result = 0;
        for(int i = 0;i < accounts.length; i++){
            int sum = 0;
            for(int j = 0; j < accounts[i].length; j++){
                sum+= accounts[i][j];
            }
            result = Math.max(result, sum);
        }
        return result;
    }
}
