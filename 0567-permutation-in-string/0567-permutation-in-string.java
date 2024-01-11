import java.util.HashMap;

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> mp = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            mp.put(c, mp.getOrDefault(c, 0) + 1);
        }

        int remainingChars = s1.length();

        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);

            if (mp.containsKey(c)) {
                mp.put(c, mp.get(c) - 1);
                if (mp.get(c) >= 0) {  // Adjust this condition
                    remainingChars--;
                }
            }

            if (remainingChars == 0) {
                return true;
            }

            if (i >= s1.length() - 1) {
                char startChar = s2.charAt(i - (s1.length() - 1));
                if (mp.containsKey(startChar)) {
                    mp.put(startChar, mp.get(startChar) + 1);
                    if (mp.get(startChar) > 0) {
                        remainingChars++;
                    }
                }
            }
        }

        return false;
    }
}
