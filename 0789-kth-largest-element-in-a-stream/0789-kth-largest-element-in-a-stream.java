class KthLargest {
    private PriorityQueue<Integer> maxHeap;
    private int find;
    public KthLargest(int k, int[] nums) {
        this.find = k;
        maxHeap = new PriorityQueue<>();
        for(int i = 0; i < nums.length; i++){
            maxHeap.add(nums[i]);
            if(maxHeap.size() > k){
                maxHeap.poll();
            }
        }
    }
    
    public int add(int val) {
        maxHeap.add(val);
        while(maxHeap.size() > find){
            maxHeap.remove();
        }
        return maxHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */