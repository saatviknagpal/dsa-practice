class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        int r = matrix.length;
        int c = matrix[0].length;
        
        int row = 0, column = 0;
        
        List<Integer> ans = new ArrayList<Integer>();
        
        while(row<r && column<c){
            
            for(int i=column;i<c;i++){
                
                ans.add(matrix[row][i]);
            }
            row++;
            
            for(int i=row;i<r;i++){
                
                ans.add(matrix[i][c-1]);
            }
            c--;
            
            if(row<r){
			
                for(int i=c-1;i>=column;i--){
                    
                    ans.add(matrix[r-1][i]);
                }
                r--;
            }
            
            if(column<c){
                
                for(int i=r-1;i>=row;i--){
                    
                    ans.add(matrix[i][column]);
                }
                column++;
            }
            
        }
        
        return ans;
    }
}