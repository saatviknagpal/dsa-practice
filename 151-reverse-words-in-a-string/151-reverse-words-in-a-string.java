class Solution {
    public String reverseWords(String s) {
        Stack<String> st = new Stack<String>();
        for (String a : s.trim().split(" ")) {
            if (!a.isEmpty())
                st.push(a);
        }
        
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
            sb.append(" ");            
        }
        
        return sb.toString().trim();
    }

}