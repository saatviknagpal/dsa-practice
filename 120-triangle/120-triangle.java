class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        for(int i=triangle.size()-2;i>=0;i--){
            for(int j=0;j<triangle.get(i).size();j++){
                int min=Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1));
                int sum=min + triangle.get(i).get(j);
                triangle.get(i).set(j,sum);
            }
        }
        return triangle.get(0).get(0);
    }
}
