class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] arr = new int[60];
        int count = 0;
        for(int i = 0; i < time.length; i++){
            int remainder = time[i]%60;
            int diff = (60- remainder)% 60;
            count = count + arr[diff];
            arr[remainder]++;
        }
        return count;
    }
}

