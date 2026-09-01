class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adj = new HashMap();
        for(int time[] : times){
            adj.computeIfAbsent(time[0], key-> new ArrayList<int[]>()).add(new int[] {time[1], time[2]});
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
  
            return a[1] - b[1];
        });
        pq.add(new int[]{k,0});
        Set<Integer> visited = new HashSet();
        int res= 0;
        while(!pq.isEmpty()){
            int[] current = pq.poll();
            int u= current[0];
            int d = current[1];
            if(visited.contains(u)) continue;
            visited.add(u);
            res = d;
            for(int[] neighbour: adj.getOrDefault(u,new ArrayList<>())){
                int v = neighbour[0];
                int weight = neighbour[1];
                if(!visited.contains(v)){
                    pq.offer(new int[]{v, d + weight});
                }
            }
        }
        
      
        return visited.size()== n? res:-1;

    }

}
