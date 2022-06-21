// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N=sc.nextInt();
			ArrayList<Integer> arr = new ArrayList<>();
			for(int i = 0; i < N ; i++){
			    arr.add(sc.nextInt());
			}
            Solution ob = new Solution();
         
            ArrayList<Integer> ans = ob.subsetSums(arr,N);
            Collections.sort(ans);
            for(int sum : ans){
                System.out.print(sum+" ");
            }
            System.out.println();
        }  
    }
}
// } Driver Code Ends


//User function Template for Java//User function Template for Java
class Solution{
    
    void func(int i, int sum, ArrayList<Integer> arr, int N, ArrayList<Integer> sumOfSubsets){
        if(i == N){
            sumOfSubsets.add(sum);
            return;
        }
        
        func(i+1, sum + arr.get(i), arr, N, sumOfSubsets );
        func(i+1, sum, arr, N, sumOfSubsets );
    }
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
       ArrayList<Integer> sumOfSubsets = new ArrayList<>();
       func(0,0,arr,N,sumOfSubsets);
       Collections.sort(sumOfSubsets);
       return sumOfSubsets;
    }
}