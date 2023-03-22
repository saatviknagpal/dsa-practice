class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        QuickUnion uf = new QuickUnion(n);
        for(int[] edge: edges){
            uf.union(edge[0], edge[1]);
        }
        return uf.connected(source, destination);
    }
}

public class QuickUnion {
    private int[] id;

    public QuickUnion(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    private int root(int i) {
        while (i != id[i]) i = id[i];
        return i;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        id[i] = j;
    }
    
}