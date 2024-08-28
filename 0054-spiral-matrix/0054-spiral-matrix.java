class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int i = 0;
        int j = 0;

        int up = 0;
        int down = n - 1; 
        int right = m - 1;
        int left = 0; 

        String direction = "right";

        List<Integer> list = new ArrayList<>();

        while(list.size() != n*m){
            if(direction.equals("right")){
                while(j <= right){
                    list.add(matrix[i][j]);
                    j++;
                }
                j--; 
                i++; 
                up++;
                direction = "down";
            } else if(direction.equals("down")){
                while(i <= down){
                    list.add(matrix[i][j]);
                    i++;
                }
                i--;
                j--;
                right--;
                direction = "left";
            } else if(direction.equals("left")){
                while(j >= left){
                    list.add(matrix[i][j]);
                    j--;
                }
                j++; 
                i--; 
                down--;
                direction = "up";
            } else if(direction.equals("up")){
                while(i >= up){
                    list.add(matrix[i][j]);
                    i--;
                }
                i++; 
                j++; 
                left++;
                direction = "right";
            }
        }

        return list;
    }
}
