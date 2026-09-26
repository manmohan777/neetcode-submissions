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
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        q.add(new int[]{k,0});
        dist[k] = 0;
       while(!q.isEmpty()){
          int[] current = q.poll();
          int u = current[0];
          int weight = current[1];
          if(weight> dist[u]) continue;
          for(int[] nei: adj.getOrDefault(u,new ArrayList<>())){
            int v= nei[0];
            int d = nei[1];
            if(weight+d < dist[v]){
                dist[v]=weight+d;
                q.offer(new int[]{v,dist[v]});
            }
          }
       }
       int res = 0;
        for(int i = 1; i< dist.length; i++){
            if(dist[i]==Integer.MAX_VALUE) return -1;
            res=Math.max(dist[i], res);
        }

        return res;
    }
}
