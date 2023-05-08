class DataStream {

    private int val, k;
    
    public List<Integer> ip = new ArrayList<>();
    public DataStream(int value, int k) {
        this.val = value;
        this.k = k;
    }
    
    int left = 0;
    int right = 0;
    int count = 0;
    boolean ans = false;
    public boolean consec(int num) {
        ip.add(num);
        
        if(ip.get(right) == val) count++;
        
        if((right - left + 1) >= k) {
            if(count == k) ans = true;
            else ans = false;
            
            if(ip.get(left) == val) count--;
            
            left++;
        }
        
        right++;
        
        return ans;
    }
}

/**
 * Your DataStream object will be instantiated and called as such:
 * DataStream obj = new DataStream(value, k);
 * boolean param_1 = obj.consec(num);
 */