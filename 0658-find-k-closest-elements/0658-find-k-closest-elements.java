class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int integer : arr) {
            if (k > 0) {
                minHeap.offer(integer);
                k--;
            } else if (Math.abs(minHeap.peek() - x) > Math.abs(integer - x)) {
                minHeap.poll();
                minHeap.offer(integer);
            }
        }
        List<Integer> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll());
        }
        return result;
    }
}