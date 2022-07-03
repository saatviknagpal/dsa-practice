class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> result = new ArrayList<>();
        int factorial = 1;
        
        for(int i = 1; i < n; i++){
            factorial = factorial * i;
            result.add(i);
        }
        result.add(n);
        String ans = "";
        k = k -1;
        
        while(true){
            ans = ans + result.get(k/factorial);
            result.remove(k/factorial);
            
            if(result.size() == 0){
                break;
            }
            
            k = k %factorial;
            factorial = factorial/ result.size();
            
        }
        return ans;
    }
}