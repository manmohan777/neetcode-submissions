class Solution {
    public boolean validTree(int n, int[][] edges) {
        Set<Integer> visited = new HashSet();
        Map<Integer,List<Integer>> map = new HashMap();
        for(int []edge : edges){
            map.computeIfAbsent(edge[0],k-> new ArrayList()).add(edge[1]);
            map.computeIfAbsent(edge[1],k-> new ArrayList()).add(edge[0]);
        }
        
        if(!dfs(map,-1,0,visited))
            return false;
        
        return visited.size()==n;
    }
    boolean dfs(Map<Integer,List<Integer>> map,int parent, int u, Set<Integer> visited){
        visited.add(u);
        for(int v: map.getOrDefault(u, new ArrayList<Integer>())){
            if(!visited.contains(v)){
                if(!dfs(map,u,v,visited)){
                    return false;
                }
            }else if(v!= parent){
                return false;
            }
        }
        return true;
    }
}
