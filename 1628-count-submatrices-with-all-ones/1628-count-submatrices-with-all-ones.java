class Solution {
    public int numSubmat(int[][] mat) {
        int m = mat.length, n = mat[0].length, height[] = new int[n], res = 0;
        for (int i = 0; i < m; i++) {
            Stack<int[]> st = new Stack<>();
            for (int j = 0; j < n; j++) {
                height[j] = mat[i][j] == 0 ? 0 : (height[j] + 1);
                int sum = 0;
                while (!st.isEmpty() && height[st.peek()[0]] >= height[j])
                    st.pop();
                if (!st.isEmpty())
                    sum += height[j] * (j - st.peek()[0]) + st.peek()[1];
                else
                    sum += height[j] * (j + 1);
                st.push(new int[] { j, sum });
                res += sum;
            }
        }
        return res;
    }
}