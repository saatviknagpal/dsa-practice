class Solution {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) { //bfs
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[image.length][image[0].length];
        int color = image[sr][sc];
        q.add(new int[] { sr, sc });

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int r = cur[0];
                int c = cur[1];

                if (image[r][c] == color && !visited[r][c]) {
                    image[r][c] = newColor;
                    visited[r][c] = true;

                    if (r + 1 < image.length) q.add(new int[] { r + 1, c });
                    if (r - 1 >= 0) q.add(new int[] { r - 1, c });
                    if (c + 1 < image[0].length) q.add(new int[] { r, c + 1 });
                    if (c - 1 >= 0) q.add(new int[] { r, c - 1 });
                }
            }
        }

        return image;
    }
}
