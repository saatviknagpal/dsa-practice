class Solution {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int[] arr = {1,2,3,4,5,6,7,8,9};
        
        findCombinations(k, n, arr, 0, res, new ArrayList<Integer>());
        return res;
    }

    public static void findCombinations(int k, int n, int[] arr, int index, List<List<Integer>> res, List<Integer> ans) {
        if (k == 0 && n == 0) {
            res.add(new ArrayList<Integer>(ans));
        } else {
            for (int i = index; i < arr.length && n > 0 && k > 0; i++) {
                ans.add(arr[i]);
                findCombinations(k - 1, n - arr[i], arr, i + 1, res, ans);
                ans.remove(ans.size() - 1);
            }
        }
    }
}
