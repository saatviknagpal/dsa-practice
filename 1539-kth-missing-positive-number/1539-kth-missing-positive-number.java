class Solution {

    public int findKthPositive(int[] arr, int k) {
        int n = 1, i = 0;
        while (i < arr.length) {
            if (n != arr[i]) k--; //Missing number.
            else if (n == arr[i]) i++;
            if (k == 0) return n;
            n++;
        }
        return n + k - 1;
    }
}
