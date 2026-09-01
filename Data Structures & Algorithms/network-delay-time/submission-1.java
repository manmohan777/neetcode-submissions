class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adj = new HashMap();
        for(int time[] : times){
            adj.computeIfAbsent(time[0], key-> new ArrayList<int[]>()).add(new int[] {time[1], time[2]});
        }
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            if(a[1] == b[1]) return a[0] - b[0];
            return a[1] - b[1];
        });
        pq.add(new int[]{k,0});
        dist[k-1]=0;
        while(!pq.isEmpty()){
            int[] current = pq.poll();
            int u= current[0];
            int d = current[1];
            if(d>dist[u-1]) continue;
            for(int[] neighbour: adj.getOrDefault(u,new ArrayList<>())){
                int v = neighbour[0];
                int weight = neighbour[1];
                if(d+weight< dist[v-1]){
                    dist[v-1] = d+weight;
                    pq.add(new int[]{v, dist[v-1]});
                }
            }
        }
        
        int res=Integer.MIN_VALUE;
        for(int d: dist){ 
            System.out.print(d+" ");
            res=Math.max(d,res);
        }
        return res== Integer.MAX_VALUE? -1:res;

    }

}
