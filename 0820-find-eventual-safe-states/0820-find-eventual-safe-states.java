class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new ArrayList<Integer>();
        int[] visited = new int[graph.length];
        
        for (int i = 0; i < graph.length; i++) {
            if (isSafe(i, graph, visited)) {
                res.add(i);
            }
        }
        
        return res;
    }
    
    private boolean isSafe(int index, int[][] graph, int[] visited) {
        if (visited[index] == 2) {
            return true;
        }
        
        if (visited[index] == 1) {
            return false;
        }
        
        visited[index] = 1;
        int[] neighbor = graph[index];
        
        for (int i = 0; i < neighbor.length; i++) {
            if (!isSafe(neighbor[i], graph, visited)) {
                return false;
            }
        }
        
        visited[index] = 2;
        return true;
    }

}