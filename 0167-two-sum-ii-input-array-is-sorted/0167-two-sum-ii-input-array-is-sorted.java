class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;

        while(i < j){
            int x = numbers[i];
            int y = numbers[j];

            if(x + y > target){
                j--;
            } else if (x + y < target){
                i++;
            } else{
                break;
            }
        }

        return new int[]{i+1, j+1};
    }
}