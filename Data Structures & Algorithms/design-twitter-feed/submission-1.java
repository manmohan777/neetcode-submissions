class Twitter {
    Map<Integer, List<Integer[]>> tweets = new HashMap<Integer, List<Integer[]>>(); //(userid-> list<tweetid,time>)
    Map<Integer, Set<Integer>> following = new HashMap<Integer, Set<Integer>>();
    int time = 0;

    public Twitter() {
        
    }
    
    public void postTweet(int userId, int tweetId) {
        tweets.computeIfAbsent(userId,key -> new ArrayList()).add(new Integer[]{tweetId,time});
        time++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Integer[]> pq = new PriorityQueue<Integer[]>((a,b)-> a[1]-b[1]);
        for(Integer tweet[] : tweets.getOrDefault(userId,new ArrayList<Integer[]>())){
            pq.offer(tweet);
            if(pq.size()>10)
                pq.poll();
        }
        for(Integer user: following.getOrDefault(userId,new HashSet<Integer>())){
            for(Integer tweet[] : tweets.getOrDefault(user,new ArrayList<Integer[]>())){
                pq.offer(tweet);
                if(pq.size()>10)
                    pq.poll();
            }
        }
        List<Integer> res = new ArrayList();
        while(!pq.isEmpty()){
            res.add(pq.poll()[0]);
        }
        Collections.reverse(res);
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        following.computeIfAbsent(followerId,key-> new HashSet<Integer>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        following.computeIfAbsent(followerId,key-> new HashSet<Integer>()).remove(followeeId);
    }
}
