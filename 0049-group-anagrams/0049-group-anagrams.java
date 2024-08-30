class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();

        String[] sortedStrs = new String[strs.length];

        for (int i = 0; i < strs.length; i++) {
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            String s = String.valueOf(arr);
            sortedStrs[i] = s;
        }

        HashMap<String, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            if (map.containsKey(sortedStrs[i])) {
                map.get(sortedStrs[i]).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(sortedStrs[i], list);
            }
        }

        for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            String key = entry.getKey();
            List<Integer> value = entry.getValue();
            List<String> ans = new ArrayList<>();
            for(int i : value){
                ans.add(strs[i]);
            }
            result.add(ans);
        }

        return result;
    }
}