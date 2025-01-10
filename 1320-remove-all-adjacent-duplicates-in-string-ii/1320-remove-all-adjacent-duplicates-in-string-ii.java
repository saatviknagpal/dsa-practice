class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Character> st = new Stack<>();
        Stack<Integer> counts = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (!st.isEmpty() && st.peek() == c) {
                int count = counts.pop() + 1;
                counts.push(count);
                st.push(c);

                if (count == k) {
                    for (int j = 0; j < k; j++) {
                        st.pop();
                    }
                    counts.pop();
                }
            } else {
                st.push(c);
                counts.push(1); 
            }
        }

        StringBuilder result = new StringBuilder();
        while (!st.isEmpty()) {
            result.append(st.pop());
        }

        return result.reverse().toString();
    }
}
