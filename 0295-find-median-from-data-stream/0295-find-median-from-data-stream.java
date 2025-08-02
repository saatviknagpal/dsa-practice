class MedianFinder {

    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;
    public MedianFinder() {
        
        this.maxHeap = new PriorityQueue<Integer>((a,b) -> b - a);
        this.minHeap = new PriorityQueue<Integer>();
    }
    
    public void addNum(int num) {
        if(maxHeap.isEmpty() || num <= maxHeap.peek()){
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }

        if(maxHeap.size() > minHeap.size() + 1){
            minHeap.add(maxHeap.poll());
        } else if(minHeap.size() > maxHeap.size()){
            maxHeap.add(minHeap.poll());
        }
        
    }
    
    public double findMedian() {
        if(maxHeap.size() > minHeap.size()){
            return maxHeap.peek();
        } else {
            return (maxHeap.peek() + minHeap.peek())/ 2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */