class Solution {
    public String robotWithString(String s) {
        Stack<Character> st = new Stack<>();

        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        StringBuilder t = new StringBuilder();

        for (char ch : s.toCharArray()) {
            st.push(ch);
            freq[ch - 'a']--;
            while (!st.isEmpty() && st.peek() <= smallestChar(freq)) {
                t.append(st.pop());
            }

        }

        while (!st.isEmpty()) {
            t.append(st.pop());
        }

        return t.toString();
    }

    private char smallestChar(int[] freq) {
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                return (char) ('a' + i);
            }
        }

        return 'a';
    }
}