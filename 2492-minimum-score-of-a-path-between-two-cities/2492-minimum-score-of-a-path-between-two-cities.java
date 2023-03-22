class Solution {

    public int minScore(int n, int[][] roads) {
        UnionFind uf = new UnionFind(n + 1);
        for (int[] road : roads) uf.union(road[0], road[1], road[2]);

        int group = uf.find(1);
        if (group == uf.find(n)) return uf.distance[group];

        return -1;
    }

    public class UnionFind {
        private int[] root;
        private int[] rank;
        private int[] distance;

        public UnionFind(int size) {
            root = new int[size];
            rank = new int[size];
            distance = new int[size];
            for (int i = 0; i < size; i++) {
                root[i] = i;
                rank[i] = 1;
                distance[i] = Integer.MAX_VALUE;
            }
        }

        public int find(int x) {
            if (x == root[x]) return x; else return root[x] = find(root[x]);
            
        }

        public void union(int x, int y, int d) {
            int rootX = find(x);
            int rootY = find(y);

            int minD = Math.min(distance[rootX], distance[rootY]);
            minD = Math.min(minD, d);
            distance[rootX] = distance[rootY] = minD;

            if (rootX == rootY) return;

            if (rank[rootX] < rank[rootY]) {
                root[rootX] = rootY;
            } else {
                root [rootY] = rootX;
                if (rank[rootX] == rank[rootY]) rank[rootX]++;
            }
        }
    }
}
