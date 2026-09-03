class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {       int[] dists = new int[n];
        Arrays.fill(dists,Integer.MAX_VALUE);
        Map<Integer,List<int[]>> adj = new HashMap();
        for(int[] flight : flights){
            int u = flight[0], v = flight[1], price = flight[2];
            adj.computeIfAbsent(u, key-> new ArrayList<>()).add(new int[]{v,price});
        }
        Queue<int[]> pq = new LinkedList<>(); //{dist,stops,node}
        pq.add(new int[]{0,src});
        dists[src] = 0;
        int stops=0;
        while(!pq.isEmpty() && stops<=k){
            int size = pq.size();
            for(int i=0; i< size; i++) {
                int[] current = pq.poll();
                int dist = current[0], u = current[1];
                for(int[] nei : adj.getOrDefault(u, new ArrayList<>())){
                    int weight =nei[1], v = nei[0];
                    if(weight+dist < dists[v]){
                        dists[v] = weight+dist;
                        pq.add(new int[]{
                            dists[v],
                            v});
                    }
                } 
            }
          
            stops++;
        }
        if(dists[dst]!=Integer.MAX_VALUE) return dists[dst];
        return -1;
    }
}
