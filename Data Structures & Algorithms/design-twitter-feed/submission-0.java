
//my design but had multiple errors, chatgpt fixed them
class Twitter {

    // userId -> list of {tweetId, timestamp}
    Map<Integer, List<int[]>> tweets;

    // follower -> followees
    Map<Integer, List<Integer>> following;

    int timestamp;

    public Twitter() {
        tweets = new HashMap<>();
        following = new HashMap<>();
        timestamp = 0;
    }

    public void postTweet(int userId, int tweetId) {

        List<int[]> tweetList = tweets.getOrDefault(userId, new ArrayList<>());

        tweetList.add(new int[]{tweetId, timestamp++});

        tweets.put(userId, tweetList);
    }

    public List<Integer> getNewsFeed(int userId) {

        //create a comparator for the PQ to sort from largest to smallest
        //aka most recent to least recent
        Comparator<int[]> cmp = new Comparator<>(){ 
            @Override public int compare(int[] a, int[] b){ 
                return Integer.compare(b[1], a[1]); 
            } 
        };

        //PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));
        //or use below
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(cmp);

        for (int[] t : tweets.getOrDefault(userId, new ArrayList<>())) {
            pq.offer(t);
        }

        for (int followee : following.getOrDefault(userId, new ArrayList<>())) {

            for (int[] t : tweets.getOrDefault(followee, new ArrayList<>())) {
                pq.offer(t);
            }
        }

        List<Integer> res = new ArrayList<>();

        while (!pq.isEmpty() && res.size() < 10) {
            res.add(pq.poll()[0]);
        }

        return res;
    }

    public void follow(int followerId, int followeeId) {

        if (followerId == followeeId)
            return;

        List<Integer> list = following.getOrDefault(followerId, new ArrayList<>());

        if (!list.contains(followeeId)) {
            list.add(followeeId);
        }

        following.put(followerId, list);
    }

    public void unfollow(int followerId, int followeeId) {

        List<Integer> list = following.getOrDefault(followerId, new ArrayList<>());

        list.remove(Integer.valueOf(followeeId));

        following.put(followerId, list);
    }
}