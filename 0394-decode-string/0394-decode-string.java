import java.util.Stack;

class Solution {
    public String decodeString(String s) {
        StringBuilder d = new StringBuilder();
        Stack<Object> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == ']') {
                StringBuilder temp = new StringBuilder();
                while (!st.isEmpty() && !(st.peek() instanceof Character && (char) st.peek() == '[')) {
                    temp.insert(0, st.pop());
                }
                st.pop();
                StringBuilder countBuilder = new StringBuilder();
                while (!st.isEmpty() && st.peek() instanceof Character && Character.isDigit((char) st.peek())) {
                    countBuilder.insert(0, st.pop());
                }
                int count = Integer.parseInt(countBuilder.toString());
                String repeated = temp.toString().repeat(count);
                st.push(repeated);
            } else {
                st.push(c);
            }
        }

        while (!st.isEmpty()) {
            d.insert(0, st.pop());
        }

        return d.toString();
    }
}
