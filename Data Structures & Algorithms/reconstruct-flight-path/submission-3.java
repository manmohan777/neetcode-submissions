class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> adj = new HashMap();
        for(List<String> ticket: tickets){
            String u = ticket.get(0);
            String v = ticket.get(1);
            adj.computeIfAbsent(u, key-> new PriorityQueue<>()).offer(v);
        }

        List<String> res = new ArrayList();
        dfs(adj,res,"JFK");
        Collections.reverse(res);
        return res;
    }
    void dfs(Map<String,PriorityQueue<String>> adj, List<String> res,String u){
        PriorityQueue<String> pq = adj.getOrDefault(u, new PriorityQueue<>());
        while(!pq.isEmpty()){
            String v = pq.poll();
            dfs(adj,res,v);
        }
        res.add(u);
    }
}
