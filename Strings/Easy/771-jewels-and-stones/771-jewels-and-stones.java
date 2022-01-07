class Solution {

    public int numJewelsInStones(String jewels, String stones) {
        HashSet<Character> set = new HashSet<>();

        for (int i = 0; i < jewels.length(); i++) {
            char c = jewels.charAt(i);
            if (!set.contains(c)) {
                set.add(c);
            }
        }
        int res = 0;
        for (int i = 0; i < stones.length(); i++) {
            char c = stones.charAt(i);
            if (set.contains(c)) {
                res++;
            }
        }
        return res;
    }
}
