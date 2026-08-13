class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        Queue <int[]>pacQ = new LinkedList();
        Queue atlQ = new LinkedList();
        for(int i=0; i < rows; i++){
            pacQ.offer(new int[]{i,0});
            atlQ.offer(new int[]{i,cols-1});
        }
        for(int i=0; i < cols; i++){
            pacQ.offer(new int[]{0,i});
            atlQ.offer(new int[]{rows-1,i});
        }
        boolean visPac[][] = new boolean[rows][cols];
        boolean visAtl[][] = new boolean[rows][cols];
        bfs(visPac,heights,pacQ);
        bfs(visAtl,heights,atlQ);
        List<List<Integer>> res=new ArrayList();
        for(int i=0; i < rows; i++){
            for( int j=0; j< cols; j++){
                if(visPac[i][j] && visAtl[i][j]){
                    List<Integer> index=new ArrayList();
                    index.add(i);
                    index.add(j);
                    res.add(index);
                }
            }
        }
        return res;
    }

    void bfs(boolean[][] vis,int[][] heights, Queue<int[]> q){
        int dirs[][] = {{0,1},{0,-1},{1,0},{-1,0}};
        while(!q.isEmpty()){
            int current[] = q.poll();
            int r=current[0],c = current[1];
            vis[r][c] = true;
            for(int[] dir: dirs){
                int nr=r+dir[0], nc=c+dir[1];
                if(nr>=0 && nc >=0
                && nr<heights.length && nc< heights[0].length
                && !vis[nr][nc]
                && heights[r][c]<=heights[nr][nc]){
                    q.add(new int[]{nr,nc});
                }
            }
        }
    }
}
