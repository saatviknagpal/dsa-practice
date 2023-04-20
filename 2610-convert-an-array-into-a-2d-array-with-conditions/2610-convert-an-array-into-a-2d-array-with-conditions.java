class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            set.add(nums[i]);
        }
        List<List<Integer>> ans=new ArrayList<>();
        while(map.size()!=0){
            List<Integer> curr=new ArrayList<>();
            for(int ele:set){
                if(map.containsKey(ele)){
                    int count=map.get(ele);
                    curr.add(ele);
                    if(count==1){
                        map.remove(ele);
                    }
                    else{
                        map.put(ele,count-1);
                    } 
                }  
            }
            ans.add(curr);
        }
        return ans;
    }
}