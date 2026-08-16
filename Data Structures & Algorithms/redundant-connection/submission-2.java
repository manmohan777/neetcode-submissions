class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap();
        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];
            
            map.computeIfAbsent(u,key-> new ArrayList()).add(v);
            map.computeIfAbsent(v,key-> new ArrayList()).add(u);
            if(!dfs(map,u,v,new HashSet()))
                return edge;
        }
        
        return new int[0];
    }

 boolean dfs(Map<Integer, List<Integer>> map, int u, int parent, Set<Integer> visited){
        visited.add(u);
        for(int v: map.getOrDefault(u, new ArrayList<Integer>())){
            if(!visited.contains(v)){
                if(!dfs(map,v,u,visited)){
                    return false;
                }
                
            }else if(v!=parent){
                return false;
            }
        }
        return true;
    }
}
