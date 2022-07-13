/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc= new Scanner(System.in);
 int T = sc.nextInt();
 while(T>0){
     int arrs = sc.nextInt();
        int k= sc.nextInt();
        int arr[] = new int[arrs];
        for(int j =0;j<arrs;j++){
            arr[j]=sc.nextInt();
        }
       PriorityQueue<Integer> p = new PriorityQueue<>();
       for(int i=0; i<arrs; i++){
        p.add(arr[i]);
        if(p.size() > k)
        {
            System.out.print(p.peek()+" ");
            p.poll();

        }
        }
        while(p.size() > 0){
       System.out.print(p.peek()+" ");
             p.poll();
        }
        System.out.println();
        T--;
 }
	}
}