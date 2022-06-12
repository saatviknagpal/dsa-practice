// { Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);

            int start[] = new int[n];
            int end[] = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) 
                end[i] = Integer.parseInt(inputLine[i]);
                
            int ans = new Solution().maxMeetings(start, end, n);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution 
{
	public static int maxMeetings(int start[],int end[],int n)
    {
        ArrayList<int[]> al = new ArrayList<>();
        for(int i = 0; i < n; i++)
            al.add(new int[]{start[i] , end[i]});
            
        Collections.sort(al , (a, b)->(a[1] - b[1]));
    
        int res = 1 , prev = 0;
        for(int curr = 1; curr < n; curr++)
        {
            if(al.get(curr)[0] > al.get(prev)[1])
            {
                res++;
                prev = curr;
            }
        }
        
        return res;
    }
}
