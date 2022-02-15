class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i : nums){
            if(map.containsKey(i)){
                map.put(i, map.get(i) +1);
            }
            else{
                map.put(i, 1);
            }
        }
        for (Map.Entry<Integer, Integer> set : map.entrySet()) {
            if(set.getValue() == 1){
                return set.getKey();
            }
        }
        return -1;
            
    }
}