class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }
        for (int i = 1; i < words.length; i++) {
            String word1 = words[i - 1];
            String word2 = words[i];
            int len = Math.min(word1.length(), word2.length());
            if(len != word1.length() && len == word2.length() && word1.startsWith(word2)){
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
