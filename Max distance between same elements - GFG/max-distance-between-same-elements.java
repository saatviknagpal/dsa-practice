// { Driver Code Starts
import java.util.Scanner;
import java.util.*;

class GFG
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t =sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			int arr[] = new int[n];
			for(int i=0;i<n;i++)
				arr[i] = sc.nextInt();
			Solution ob = new Solution();
			System.out.println(ob.maxDistance(arr,n));
		
		t--;
		}
	}
}// } Driver Code Ends


// your task is to complete this function
class Solution
{
    int maxDistance(int arr[], int n)
    {
	    HashMap<Integer,Integer> map = new HashMap<>();
	    
	    for(int i = 0 ; i < n; i++){
	        if(!map.containsKey(arr[i])){
	            map.put(arr[i], i);
	        }
	    }
	    int ans = Integer.MIN_VALUE;
	    for(int i=n-1; i>=0; i--){
        if(map.containsKey(arr[i])){
           
            int temp=Math.abs(map.get(arr[i])-i);
            ans = Math.max(ans, temp);
        }
    }
    return ans;
    }
}
