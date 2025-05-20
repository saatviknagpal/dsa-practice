class Solution {
    private static final int MOD = 1_000_000_007;

    public int getNumberOfBacklogOrders(int[][] orders) {
        PriorityQueue<int[]> buyBacklog = new PriorityQueue<>((a, b) -> b[0] - a[0]); 
        PriorityQueue<int[]> sellBacklog = new PriorityQueue<>(Comparator.comparingInt(a -> a[0])); 

        for (int[] order : orders) {
            int price = order[0], amount = order[1], type = order[2];

            if (type == 0) {
                while (amount > 0 && !sellBacklog.isEmpty() && sellBacklog.peek()[0] <= price) {
                    int[] sell = sellBacklog.poll();
                    int min = Math.min(amount, sell[1]);
                    amount -= min;
                    sell[1] -= min;
                    if (sell[1] > 0) sellBacklog.add(sell);
                }
                if (amount > 0) buyBacklog.add(new int[]{price, amount});
            } else {
                while (amount > 0 && !buyBacklog.isEmpty() && buyBacklog.peek()[0] >= price) {
                    int[] buy = buyBacklog.poll();
                    int min = Math.min(amount, buy[1]);
                    amount -= min;
                    buy[1] -= min;
                    if (buy[1] > 0) buyBacklog.add(buy);
                }
                if (amount > 0) sellBacklog.add(new int[]{price, amount});
            }
        }

        long total = 0;
        for (PriorityQueue<int[]> queue : List.of(buyBacklog, sellBacklog)) {
            while (!queue.isEmpty()) {
                total = (total + queue.poll()[1]) % MOD;
            }
        }

        return (int) total;
    }
}
