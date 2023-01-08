class Solution {
    public int maxPoints(int[][] points) {
        int max=1;
        HashMap<Double,Integer> map=new HashMap<>();
        for(int i=0;i<points.length-1;i++)
        {
            map=new HashMap<>();

            for(int j=i+1;j<points.length;j++)
            {

                Double temp=(double)(points[j][1]-points[i][1])/(points[j][0]-points[i][0]);
                if(temp==-0) temp=0.00;

                else if(temp==Double.NEGATIVE_INFINITY) temp=Double.POSITIVE_INFINITY;

                if(map.containsKey(temp)) 
                     map.put(temp,map.get(temp)+1);
                else 
                     map.put(temp,2);
                     
                max=Math.max(max,map.get(temp));
            }
        }
        return max;
    }
}