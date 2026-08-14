class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean visited[] = new boolean[numCourses];
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int[] pre: prerequisites){
            map.computeIfAbsent(pre[0],k-> new ArrayList()).add(pre[1]);
        }
        for(int i=0;i<numCourses; i++){
            if(!dfs(map,i,visited))
                return false;
        }
        return true;
    }
    boolean dfs(Map<Integer,List<Integer>> map, int v,boolean[] visited){
        if(visited[v])
            return false;
        if(!map.containsKey(v)){
            return true;
        }
        visited[v]=true;
        for(int pre: map.get(v)){
            if(!dfs(map,pre,visited)){
                return false;
            }
        }
        visited[v]=false;
        map.remove(v);
        return true;
        
    }
}
