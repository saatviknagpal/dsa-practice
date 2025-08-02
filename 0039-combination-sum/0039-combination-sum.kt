class Solution {
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        val result = mutableListOf<MutableList<Int>>()
        val curr = mutableListOf<Int>()
        dfs(candidates, target, result, curr, 0)
        return result
    }

    fun dfs(candidates: IntArray, target: Int, result: MutableList<MutableList<Int>>, curr: MutableList<Int>, i : Int){

        if(target == 0){
            result.add(ArrayList(curr));
            return;
        }

        if(i >= candidates.size || target < 0){
            return;
        }

        curr.add(candidates[i]);
        dfs(candidates, target - candidates[i], result, curr, i);

        curr.removeAt(curr.size - 1);
        dfs(candidates, target, result, curr, i+1);
    }
}