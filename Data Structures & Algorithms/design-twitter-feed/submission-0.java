class Twitter {
    private Map<Integer, List<Tweet>> map;
    private Map<Integer, Set<Integer>> follows;
    private int time;

    private class Tweet {
        int tweetId;
        int time;
        public Tweet(int tweetId, int time) {
            this.tweetId = tweetId;
            this.time = time;
        }
    }

    private class Node {
        int userId;
        int index;
        Tweet tweet;
        public Node(int userId, int index, Tweet tweet) {
            this.userId = userId;
            this.index = index;
            this.tweet = tweet;
        }
    }

    public Twitter() {
        this.map = new HashMap<>();
        this.follows = new HashMap<>();
        this.time = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        if (!map.containsKey(userId)) {
            List<Tweet> list = new ArrayList<>();
            map.put(userId, list);
        }
        map.get(userId).add(new Tweet(tweetId, time));
        time++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<Node> heap = new PriorityQueue<>((a, b) -> {
            return Integer.compare(b.tweet.time, a.tweet.time);
        });

        Set<Integer> users = new HashSet<>();
        users.add(userId);
        if (follows.containsKey(userId)) {
            users.addAll(follows.get(userId));
        }
        for (int user : users) {
            if (!map.containsKey(user)) {
                continue;
            }
            List<Tweet> tweets = map.get(user);
            if (tweets.size() == 0) {
                continue;
            }
            int lastIndex = tweets.size() - 1;
            heap.offer(new Node(user, lastIndex, tweets.get(lastIndex)));
        }

        while (!heap.isEmpty() && res.size() < 10) {
            Node cur = heap.poll();
            res.add(cur.tweet.tweetId);
            int prevIndex = cur.index - 1;
            if (prevIndex >= 0) {
                List<Tweet> tweets = map.get(cur.userId);
                heap.offer(new Node(cur.userId, prevIndex, tweets.get(prevIndex)));
            }
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }
        follows.putIfAbsent(followerId, new HashSet<>());
        follows.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (!follows.containsKey(followerId)) {
            return;
        }
        follows.get(followerId).remove(followeeId);
    }
}
