class Solution {

    public int[] maxSlidingWindow(int[] arr, int k) {
        Stack<Integer> st = new Stack<>();
        int[] nge = new int[arr.length];
        st.push(arr.length - 1);
        nge[arr.length - 1] = arr.length;

        for (int i = arr.length - 2; i >= 0; i--) {
            while (!st.isEmpty() && arr[i] >= arr[st.peek()]) {
                st.pop();
            }

            if (st.size() == 0) {
                nge[i] = arr.length;
            } else {
                nge[i] = st.peek();
            }
            st.push(i);
        }
        int j = 0;
        int[] result = new int[arr.length-k + 1];
        for (int i = 0; i <= arr.length - k; i++) {
            if (j < i) {
                j = i;
            }
            while (nge[j] < i + k) {
                j = nge[j];
            }
            result[i] = arr[j];
        }
        return result;
    }
}
