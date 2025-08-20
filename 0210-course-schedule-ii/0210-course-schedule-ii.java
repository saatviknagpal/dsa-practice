class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Topological sort
        // Edge case
        if (numCourses <= 0)
            return new int[0];

        HashMap<Integer, Integer> inDegree = new HashMap<>();
        HashMap<Integer, List<Integer>> topoMap = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            inDegree.put(i, 0);
            topoMap.put(i, new ArrayList<Integer>());
        }

        for (int[] pair : prerequisites) {
            int curCourse = pair[0], preCourse = pair[1];
            topoMap.get(preCourse).add(curCourse);
            inDegree.put(curCourse, inDegree.get(curCourse) + 1);
        }
        int[] res = new int[numCourses];
        int base = 0;
        while (!inDegree.isEmpty()) {
            boolean flag = false;
            for (int key : inDegree.keySet()) {
                if (inDegree.get(key) == 0) {
                    res[base++] = key;
                    List<Integer> children = topoMap.get(key);
                    for (int child : children)
                        inDegree.put(child, inDegree.get(child) - 1);
                    inDegree.remove(key);
                    flag = true;
                    break;
                }
            }
            if (!flag)
                return new int[0];
        }
        return res;
    }
}