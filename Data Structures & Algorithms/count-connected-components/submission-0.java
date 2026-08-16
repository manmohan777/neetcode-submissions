class Solution {
    public int countComponents(int n, int[][] edges) {
        Map<Integer,List<Integer>> map = new HashMap();
        for(int edge[] :  edges){
            map.computeIfAbsent(edge[0],key-> new ArrayList()).add(edge[1]);
            map.computeIfAbsent(edge[1],key-> new ArrayList()).add(edge[0]);
        }
        Set<Integer> visited= new HashSet();
        int res=0;
        for(int i=0;i<n;i++){
            if(!visited.contains(i)){
                res++;
                dfs(map,i, visited);
            }
        }
        return res;
    }

    void dfs(Map<Integer, List<Integer>> map,int u, Set<Integer> visited){
        if(visited.contains(u)) return;
        visited.add(u);
        for(int v: map.getOrDefault(u, new ArrayList<Integer>())){
            if(!visited.contains(v)){
                dfs(map,v,visited);
            }
        }
    }
}
