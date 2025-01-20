class Solution {
    int[] temp;
    public Solution(int[] nums) {
        temp = new int[nums.length];

        for(int i = 0; i < nums.length; i++){
            temp[i] = nums[i];
        }
    }
    
    public int[] reset() {
        return temp;
    }
    
    public int[] shuffle() {
        int[] shuffledArray = new int[temp.length];

        for(int i = 0; i < temp.length; i++){
            shuffledArray[i] = temp[i];
        }

        Random random = new Random();
        for (int i = shuffledArray.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1); 
            int temp = shuffledArray[i];
            shuffledArray[i] = shuffledArray[j];
            shuffledArray[j] = temp;
        }

        return shuffledArray;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */