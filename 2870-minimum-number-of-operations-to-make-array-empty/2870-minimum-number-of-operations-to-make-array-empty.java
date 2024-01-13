class Solution {

    public int minOperations(int[] nums) {
        HashMap<Integer, Integer> mp = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
        }
        
        int count = 0;
        
        for(Map.Entry<Integer, Integer> entry : mp.entrySet()){
            int key = entry.getKey();
            if(mp.get(key) == 1){
                return -1;
            }
            if(mp.get(key) == 2){
                count += 1;
            } else {
                count += Math.ceil(mp.get(key) / 3.0) ;
            }
        }
        
        return count;
        
        
    }
}
