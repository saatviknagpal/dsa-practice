//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S[] = read.readLine().split(" ");
            int R = Integer.parseInt(S[0]);
            int C = Integer.parseInt(S[1]);
            int matrix[][] = new int[R][C];
            int c = 0;
            for(int i = 0; i < R; i++){
                String line[]=read.readLine().trim().split(" ");
                for(int j = 0; j < C; j++){
                    matrix[i][j] = Integer.parseInt(line[j]);
                }
            }
            Solution ob = new Solution();
            int ans = ob.median(matrix, R, C);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    int median(int matrix[][], int R, int C) {
        
        int low = 1;
        int high = 2000;
        int N = (R*C);
        while(low <= high){
            int mid = low + (high - low)/2;
            
            int lesserElements = findLesserElements(matrix, mid);
            
            if(lesserElements <= N/2){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return low;
    }
    
    int findLesserElements(int matrix[][], int assumedMedian){
        
        int noOfSmallerElements = 0;
        for(int i=0;i<matrix.length;i++){
            int start = 0;
            int end = matrix[i].length-1;
            while (start<=end){
                int mid = start + (end-start)/2;
                if(matrix[i][mid] <= assumedMedian){
                    start = mid+1;
                } else {
                    end = mid-1;
                }
            }
            noOfSmallerElements += start;
        }
        return noOfSmallerElements;
    }
    
}