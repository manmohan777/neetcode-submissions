class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adj = new HashMap();
        for(int time[] : times){
            int u = time[0];
            int v = time[1];
            int d = time[2];
            adj.computeIfAbsent(u, key-> new ArrayList<>()).add(new int[]{v,d});
          
        }
        int []dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{k,0});
        dist[k] = 0;
        while(!q.isEmpty()){
            int[] current = q.poll();
            int u = current[0];
            int d = current[1];
            if(d > dist[u]) continue;
            for(int[] nei: adj.getOrDefault(u,new ArrayList<>())){
                int v= nei[0];
                int weight = nei[1];
                if(dist[v] > weight+d){
                    dist[v] = weight+d;
                    q.add(new int[]{v, dist[v]});
                }
            }
        }
        int res = Integer.MIN_VALUE;;
        for(int i = 1 ; i <= n; i++){
            if(dist[i] == Integer.MAX_VALUE) return -1;
            res = Math.max(res,dist[i]);
        }
        return res;
    }
}
