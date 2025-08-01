import java.util.*;

class Twitter {
    private int time = 0;
    private Map<Integer, Set<Integer>> follows = new HashMap<>();
    private Map<Integer, List<int[]>> tweets = new HashMap<>(); // each entry: [timestamp, tweetId]

    public Twitter() {}

    public void postTweet(int userId, int tweetId) {
        time++;
        tweets.computeIfAbsent(userId, k -> new ArrayList<>())
              .add(new int[]{time, tweetId});
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        if (tweets.containsKey(userId)) {
            for (int[] t : tweets.get(userId)) {
                heap.add(t);
            }
        }
        if (follows.containsKey(userId)) {
            for (int fid : follows.get(userId)) {
                if (tweets.containsKey(fid)) {
                    for (int[] t : tweets.get(fid)) {
                        heap.add(t);
                    }
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < 10 && !heap.isEmpty(); i++) {
            result.add(heap.poll()[1]);
        }
        return result;
    }

    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        follows.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (follows.containsKey(followerId)) {
            follows.get(followerId).remove(followeeId);
        }
    }
}
