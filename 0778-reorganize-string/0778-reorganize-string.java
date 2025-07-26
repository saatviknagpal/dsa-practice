class Solution {
    public String reorganizeString(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (int f : map.values()) {
            if (f > (s.length() + 1) / 2) {
                return "";
            }
        }
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        pq.addAll(map.entrySet());

        StringBuilder sb = new StringBuilder();
        while (pq.size() > 1) {
            Map.Entry<Character, Integer> e1 = pq.poll();
            Map.Entry<Character, Integer> e2 = pq.poll();

            sb.append(e1.getKey());
            sb.append(e2.getKey());

            e1.setValue(e1.getValue() - 1);
            e2.setValue(e2.getValue() - 1);

            if (e1.getValue() > 0)
                pq.offer(e1);
            if (e2.getValue() > 0)
                pq.offer(e2);
        }

        if (!pq.isEmpty()) {
            sb.append(pq.poll().getKey());
        }

        return sb.toString();
    }
}