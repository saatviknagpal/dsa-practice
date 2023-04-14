class Solution {

    public List<String> commonChars(String[] A) {
        List<String> ans = new ArrayList<String>();
        if (A == null || A.length == 0) return ans;

        HashMap<Character, Integer> union = new HashMap<>();
        for (int i = 0; i < A[0].length(); i++) union.put(A[0].charAt(i), union.getOrDefault(A[0].charAt(i), 0) + 1);

        for (int i = 1; i < A.length; i++) {
            HashMap<Character, Integer> temp = new HashMap<>();
            for (int j = 0; j < A[i].length(); j++) {
                char curr = A[i].charAt(j);
                if (union.containsKey(curr)) temp.put(curr, Math.min(union.get(curr), temp.getOrDefault(curr, 0) + 1));
            }
            union = temp;
        }

        for (char c : union.keySet()) {
            for (int i = 0; i < union.get(c); i++) ans.add(c + "");
        }

        return ans;
    }
}
