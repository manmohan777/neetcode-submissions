class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap();
        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];
            if(map.containsKey(u)&& map.containsKey(v) && dfs(map,u,v,new HashSet()))
                return edge;
            map.computeIfAbsent(u,key-> new ArrayList()).add(v);
            map.computeIfAbsent(v,key-> new ArrayList()).add(u);
        }
        
        return new int[0];
    }

 private boolean dfs(Map<Integer, List<Integer>> map, int source, int target, Set<Integer> visited) {
        if (source == target) return true;
        
        visited.add(source);
        
        for (int neighbor : map.getOrDefault(source, Collections.emptyList())) {
            if (!visited.contains(neighbor)) {
                if (dfs(map, neighbor, target, visited)) { 
                    return true;
                }
            }
        }
        return false;
    }
}
