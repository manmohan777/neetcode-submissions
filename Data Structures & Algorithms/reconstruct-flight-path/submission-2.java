class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String,PriorityQueue<String>> adj = new HashMap<>();
        for(int i=0; i<tickets.size(); i++){
            List<String> ticket = tickets.get(i);
            adj.computeIfAbsent(ticket.get(0),key-> new PriorityQueue<String>())
            .add(ticket.get(1));
        }
        ArrayList<String> res= new ArrayList();
        dfs("JFK",adj, res);
       
        Collections.reverse(res);
        return res;
    }
    void dfs(String u, Map<String,PriorityQueue<String>> adj, List<String> res){
        PriorityQueue<String> neighbours = adj.getOrDefault(u,
                                                new PriorityQueue<String>());
        
        while(!neighbours.isEmpty()){
            String v =  neighbours.poll();
            dfs(v,adj,res);
        }
        res.add(u);
    }
}
