class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> st = new Stack<>();
        st.push(tokens[0]);
        int sum = 0;
        int i = 1;
        while(i < tokens.length){
            st.push(tokens[i]);
            if(st.peek().equals("+")){
                st.pop();
                int x = Integer.parseInt(st.pop());
                int y  = Integer.parseInt(st.pop());
                sum = x + y;
                st.push(Integer.toString(sum));
            } else if (st.peek().equals("-")){
                st.pop();
                int x = Integer.parseInt(st.pop());
                int y = Integer.parseInt(st.pop());
                sum = y - x;
                st.push(Integer.toString(sum));
            } else if(st.peek().equals("*")){
                st.pop();
                int x = Integer.parseInt(st.pop());
                int y = Integer.parseInt(st.pop());
                sum = x * y;
                st.push(Integer.toString(sum));
            } else if(st.peek().equals("/")){
                st.pop();
                int x = Integer.parseInt(st.pop());
                int y = Integer.parseInt(st.pop());
                sum = y/x;
                st.push(Integer.toString(sum));
            }
            i++;
        }
        return Integer.parseInt(st.peek());
    }
}