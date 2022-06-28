class Solution {

    public int minDeletions(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        HashSet<Integer> counts = new HashSet<>();

        int toDelete = 0;
        for (char ch : map.keySet()) {
            int cnt = map.get(ch);
            while (counts.contains(cnt)) {
                toDelete++;
                cnt--;
            }
            if (cnt > 0) counts.add(cnt);
        }
        return toDelete;
    }
}
