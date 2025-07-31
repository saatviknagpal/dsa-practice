class Solution {

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.x, b.x));

        for(int i = 0; i < points.length; i++){
            int firstVal = (int)Math.pow(points[i][0], 2);
            int secondVal = (int)Math.pow(points[i][1], 2);
            minHeap.add(new Pair(firstVal + secondVal, points[i]));
        } 


        int[][] ans = new int[k][2];
        for (int i = 0; i < k; i++) {
            ans[i] = minHeap.poll().y;
        }

        return ans;
    }
}

public class Pair {
    public int x;
    public int[] y;

    public Pair(int a, int[] b) {
        this.x = a;
        this.y = b;
    }
}