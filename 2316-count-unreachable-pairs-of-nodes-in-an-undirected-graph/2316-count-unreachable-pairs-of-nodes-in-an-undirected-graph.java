class Solution {

    class DSU {
        public int[] roots;
        public int[] size;

        DSU(int n) {
            roots = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                roots[i] = i;
                size[i] = 1;
            }
        }

        public int find(int v) {
            if (roots[v] == v) {
                return v;
            }

            int root = find(roots[v]);
            roots[v] = root;
            return root;
        }

        public void union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);

            if (rootA == rootB) {
                return;
            }
            if (size[rootA] > size[rootB]) {
                size[rootA] += size[rootB];
                roots[rootB] = rootA;
            } else {
                size[rootB] += size[rootA];
                roots[rootA] = rootB;
            }
        }

        public int getSize(int v) {
            return size[find(v)];
        }
    }

    public long countPairs(int n, int[][] edges) {
        DSU dsu = new DSU(n);
        for (int[] e : edges) {
            dsu.union(e[0], e[1]);
        }

        long result = (long) n * n;
        for (int i = 0; i < n; i++) {
            result -= (long) dsu.getSize(i);
        }

        return result / 2;
    }
}
