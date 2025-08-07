class Solution {
    public List<List<String>> partition(String s) {
        if(s == null || s.length() == 0) return new ArrayList<>();
        
        List<List<String>> result = new ArrayList<>();
        helper(s, new ArrayList<>(), result);
        return result;
    }

    public void helper(String s, List<String> step, List<List<String>> result){

        if(s == null || s.length() == 0){
            result.add(new ArrayList<>(step));
            return;
        }

        for(int i = 1; i <= s.length(); i++){
            String temp = s.substring(0, i);
            if(!isPalindrome(temp)) continue;

            step.add(temp);
            helper(s.substring(i, s.length()), step, result);
            step.remove(step.size() - 1);
        }

        return;
    }


    public boolean isPalindrome(String temp){
        int l = 0;
        int r = temp.length() - 1;
        while(l <= r){
            if(temp.charAt(l) == temp.charAt(r)){
                l++;
                r--;
            } else {
                return false;
            }
        }

        return true;
    }
}