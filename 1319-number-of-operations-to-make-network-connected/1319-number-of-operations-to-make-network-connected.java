// union find by rank solution

class Solution {
    private int[] root;
    private int[] rank;

    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) return -1;
        initialize(n);
        for (int[] edge : connections) {
            union(edge[0], edge[1]);
        }
        int independentNetworks = 0;
        for (int i = 0; i < n; i++) {
            if (i == root[i]) independentNetworks++;
        }
        return independentNetworks - 1;
    }

    private void initialize(int n) {
        this.root = new int[n];
        this.rank = new int[n];
        for (int i = 0; i < n; i++) {
            root[i] = i;
            rank[i] = 1;
        }
    }

    private int find(int x) {
        if (x == root[x]) return x;
        return root[x] = find(root[x]);
    }

    private void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            if (rank[rootX] < rank[rootY]) root[rootX] = rootY; else {
                root[rootY] = rootX;
                if (rank[rootX] == rank[rootY]) rank[rootX] += 1;
            }
        }
    }
}
