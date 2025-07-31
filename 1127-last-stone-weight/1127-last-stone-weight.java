class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for(int i = 0; i < stones.length; i++){
            maxHeap.add(stones[i]);
        }

        while(maxHeap.size() > 1){
            int x = maxHeap.poll();
            int y = maxHeap.poll();

            if(x != y) {
                maxHeap.add(x-y);
            }
        }

        return maxHeap.size() > 0 ? maxHeap.peek() : 0;
    }
}