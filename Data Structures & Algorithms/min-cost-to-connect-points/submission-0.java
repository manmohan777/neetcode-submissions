class Solution {
    
    class DSU{
        int[] parent;
        int[] rank;
        public DSU(int n){
            parent = new int[n+1];
            rank = new int[n+1];
            for(int i = 0; i<= n; i++){
                parent[i] = i;
            }
        }
        int find(int i){
            if(parent[i]==i) return i;
            return find(parent[i]);
        }
        boolean union(int a, int b){
            int pa = find(a),pb = find(b);
            if(pa == pb) return false;
            if(rank[pa]>rank[pb]){
                parent[pb] = pa;
                return true; 
            }
            if(rank[pa]<rank[pb]){
                parent[pa] = pb;
                return true; 
            }
            parent[pb] = pa;
            rank[pa]++;
            return true; 
        }
    }  
    
    public int minCostConnectPoints(int[][] points) {
        int n= points.length;
        DSU dsu = new DSU(n);
        List<int[]> edges = new ArrayList<>();
        for(int i=0; i < n; i++){
            for(int j = i+1; j< n; j++){
               int dist = Math.abs(points[i][0] - points[j][0])+Math.abs(points[i][1] - points[j][1]);
                edges.add(new int[]{dist,i,j});
            }
        }
        edges.sort((a, b)-> a[0] - b[0]);
        int res = 0;
        for(int[] edge : edges){
            if(dsu.union(edge[1],edge[2])){
                res+=edge[0];
            }
        }
        return res;
    }
    
}
