class Solution {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prev = new int[n];
        Arrays.fill(prev, Integer.MAX_VALUE);
        prev[src] = 0;

        for (int i = 0; i <= k; i++) {
            int[] curr = new int[n];
            for (int j = 0; j < n; j++) curr[j] = prev[j];

            for (int[] edge : flights) {
                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];

                if (prev[u] != Integer.MAX_VALUE && prev[u] + wt < curr[v]) {
                    curr[v] = prev[u] + wt;
                }
            }
            for (int j = 0; j < n; j++) prev[j] = curr[j];
        }

        return prev[dst] == Integer.MAX_VALUE ? -1 : prev[dst];
    }
}
