class Solution {

    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        int row = matrix.length;
        int col = matrix[0].length;
        int max, min;

        for (int i = 0; i < row; i++) {
            int minIndex = 0;
            min = Integer.MAX_VALUE;
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                    minIndex = j;
                }
            }
            max = min;
            for (int j = 0; j < row; j++) {
                max = Math.max(max, matrix[j][minIndex]);
            }
            if (min == max) {
                res.add(min);
            }
        }

        return res;
    }
}
