class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        int origColor = image[sr][sc];
        if (origColor == color) return image;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { sr, sc });
        while (!q.isEmpty()) {
            int[] val = q.poll();
            int i = val[0];
            int j = val[1];
            image[i][j] = color;

            int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
            for (int[] dir : directions) {

                int new_i = i + dir[0];
                int new_j = j + dir[1];

                if (new_i >= 0 && new_i < n && new_j >= 0 && new_j < m && image[new_i][new_j] == origColor) {
                    image[new_i][new_j] = color;
                    q.offer(new int[] { new_i, new_j });
                }
            }
        }

        return image;
    }
}