class Solution {

    public int longestConsecutive(int[] arr) {
        if(arr.length == 0 ){
            return 0;
        }
        HashSet<Integer> subsequence = new HashSet<Integer>();
        int ans = 1;
        for (int i = 0; i < arr.length; i++) {
            subsequence.add(arr[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            int start = arr[i];
            if (subsequence.contains(start - 1)) {
                continue;
            }
            while (subsequence.contains(start)) {
                start++;
            }
            ans = Math.max(ans, start - arr[i]);
        }
        return ans;
    }
}
