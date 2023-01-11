class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        // creating tree with the help of given edges
        List<List<Integer>> tree = new ArrayList<>();
        for(int i=0; i<n; i++) tree.add(new ArrayList<>());
        for(int[] e : edges) {
            int a = e[0];
            int b = e[1];
            tree.get(a).add(b);
            tree.get(b).add(a);
        }
        
        Set<Integer> vis = new HashSet<>();
        vis.add(0);
        int time = 0;
		
        // since it is given that we will start at vertex 0
        // therefore will will call dfs to all neighbours of vetex 0
        for(int child : tree.get(0)) {
            time += dfs(child, tree, hasApple, vis);
        }
        return time;
    }
    
    private int dfs(int node, List<List<Integer>> tree, List<Boolean> hasApple, Set<Integer> vis) {
        if(vis.contains(node)) return 0;
        vis.add(node);
        
        int time = 0;
        for(int child : tree.get(node)) {
            time += dfs(child, tree, hasApple, vis);
        }
        
		// if we get any vertex having apple in the sub-tree of node than the time will be greater than 0
        // so we will just increment time by 2
        // and if any vertex in sub-tree does not have any apple than time will be equal to 0
        // so we have to check if the current node has apple or not
        // if it contains apple than return 2
        return (time>0) ? (time+2) : ((hasApple.get(node)==true) ? 2 : 0);
    }
}