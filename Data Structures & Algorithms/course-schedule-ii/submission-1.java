class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
    boolean visited[] = new boolean[numCourses];
    List<Integer> res=new ArrayList();
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int[] pre: prerequisites){
            map.computeIfAbsent(pre[0],k-> new ArrayList()).add(pre[1]);
        }
        for(int i=0;i<numCourses; i++){
            if(!dfs(map,i,visited,new boolean[numCourses],res))
                return new int[0];
        }
        int[] result = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            result[i] = res.get(i);
        }
        return result;
    }
    boolean dfs(Map<Integer,List<Integer>> map, int v,boolean[] visited,
    boolean[] cycle, List<Integer> res){
        if(visited[v])
            return true;
        if(cycle[v]){
            return false;
        }
        
        cycle[v] = true;
        for(int pre: map.getOrDefault(v,new ArrayList<Integer>())){
            if(!dfs(map,pre,visited,cycle,res)){
                return false;
            }
        }
        visited[v]=true;
        res.add(v);
        return true;
    }
}