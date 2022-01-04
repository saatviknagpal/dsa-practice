class Solution {
    public int diagonalSum(int[][] mat) {
        int i = 0;
        int j = 0;
        int prisum = 0;
        while(i < mat.length && j < mat.length){
            prisum += mat[i][j];
            i++;
            j++;
        }
        i = 0;
        j = mat.length-1;
        while(i < mat.length && j >= 0){
                prisum += mat[i][j];
                i++;
                j--;
             }
        
        if(mat.length %2 != 0){
            prisum -= mat[mat.length/2][mat.length/2];
        }
        return prisum;
        
    }
}