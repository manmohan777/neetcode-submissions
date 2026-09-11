class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer,List<int[]>> adj = new HashMap();
        for(int flight[]: flights){
            int u = flight[0];
            int v = flight[1];
            int price = flight[2];
            adj.computeIfAbsent(u, key-> new ArrayList<>()).add(new int[]{v, price});
        }
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{src,0});
        int step = 0;
        int minCost[] = new int[n];
        Arrays.fill(minCost,Integer.MAX_VALUE);
        minCost[src] = 0;
        while(!q.isEmpty() && step<=k){
            int size = q.size();
            for(int i = 0; i< size; i++){
                int current[] = q.poll();
                int u = current[0];
                int currentPrice = current[1];

                for(int nei[] : adj.getOrDefault(u, new ArrayList<>())){
                    int v = nei[0];
                    int cost = nei[1];
                    if(minCost[v] > cost+currentPrice){
                        minCost[v] = cost+currentPrice;
                        q.offer(new int[]{v,currentPrice+cost});
                    }
                }
                
            }
            step++;
        }
        return minCost[dst] == Integer.MAX_VALUE? -1:minCost[dst];
    }
}
