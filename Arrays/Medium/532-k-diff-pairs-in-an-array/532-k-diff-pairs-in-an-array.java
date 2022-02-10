class Solution {
    public int findPairs(int[] nums, int k) {
        int res = 0;
        if(k < 0){
            return res;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n : nums){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        for(int a: map.keySet()){
            if(k > 0 && map.containsKey(a+k) || k == 0 && map.get(a) > 1){
                res++;
            }
        }
        return res;
    }
}