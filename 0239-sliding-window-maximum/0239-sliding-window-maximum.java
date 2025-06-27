class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int j = 0;
        int max = Integer.MIN_VALUE;

        List<Integer> result = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();

        while (j < nums.length) {
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[j]) {
                deque.pollLast();
            }

            deque.offerLast(j);
            
            if (deque.peekFirst() <= j - k) {
                deque.pollFirst();
            }

            if (j >= k - 1) {
                result.add(nums[deque.peekFirst()]); 
            }

            j++;

        }

        int[] ans = new int[result.size()];
        for (int x = 0; x < result.size(); x++) {
            ans[x] = result.get(x);
        }

        return ans;
    }
}