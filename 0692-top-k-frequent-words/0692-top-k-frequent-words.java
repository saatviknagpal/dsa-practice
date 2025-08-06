class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String word: words){
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> heap = new PriorityQueue<>(
            (a, b) -> {
                int fa = map.get(a), fb = map.get(b);
                if (fa != fb) {
                    return fa - fb;               
                }
                return b.compareTo(a);           
            }
        );

        for (String w : map.keySet()) {
            heap.offer(w);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        List<String> result = new ArrayList<>();
        while (!heap.isEmpty()) {
            result.add(heap.poll());
        }
        Collections.reverse(result);
        return result;
    }

}