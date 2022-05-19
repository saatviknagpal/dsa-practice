class Solution {
    public int findDuplicate(int[] nums) {
        Set<Integer> numbers = new HashSet<Integer>();
        for (int num : nums) {
            if (numbers.contains(num))
                return num;
            numbers.add(num);
        }
        return -1;
    }
}