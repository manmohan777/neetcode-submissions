class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> map=new HashMap();
        for(int pre[] : prerequisites){
            map.computeIfAbsent(pre[0],k->new ArrayList()).add(pre[1]);
        }
        boolean visited[] = new boolean[numCourses];
        boolean cycle[] = new boolean[numCourses];
        List<Integer> res = new ArrayList();
        for(int i=0; i< numCourses; i++){
            if(!dfs(map,visited,cycle,i,res)){
                return new int[0];
            }
        }
        int ress[] = new int[numCourses];
        for(int i=0;i< numCourses; i++){
            ress[i] = res.get(i);
        }
        return ress;
    }
   boolean dfs(Map<Integer,List<Integer>> map,boolean visited[],boolean cycle[], int u,List<Integer> res){
    if(visited[u])
        return true;
    if(cycle[u])
        return false;
        
        cycle[u] = true;
    for(int v: map.getOrDefault(u,new ArrayList<Integer>())){
        if(!dfs(map,visited,cycle,v,res)){
            return false;
        }
    }
    res.add(u);
    visited[u]= true;
    cycle[u]= false;
    return true;
   }
}