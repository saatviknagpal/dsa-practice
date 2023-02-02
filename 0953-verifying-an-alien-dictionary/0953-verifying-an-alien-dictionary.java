class Solution {
    
    // first we put every single character from order in a hashmap to lexicographically sort it as per english language
    // next we pick up two words from the array and check each character; if a character in first word greater than the second one, return false
    // corner case - if the first word is of greater length from 2nd word but the first word starts with the 2nd word return false as the less length word should come before according to dictionary
    
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }
        for (int i = 1; i < words.length; i++) {
            String word1 = words[i - 1];
            String word2 = words[i];
            int len = Math.min(word1.length(), word2.length());
            if (len != word1.length() && len == word2.length() && word1.startsWith(word2)) {
                return false;
            }
            for (int j = 0; j < len; j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    if (map.get(word1.charAt(j)) > map.get(word2.charAt(j))) {
                        return false;
                    }
                    break;
                }
            }
        }
        return true;
    }
}
