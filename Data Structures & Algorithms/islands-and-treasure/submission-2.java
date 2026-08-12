class Solution {
    int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
    public void islandsAndTreasure(int[][] grid) {
        bfs(grid);
    }
    void bfs(int[][] grid){
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0){
                    q.add(new int[]{i,j});
                }
            }
        }
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int[] node=q.poll();
                int r = node[0], c = node[1];
                for(int[] d: dir){
                    int nr = r+d[0], nc = c+d[1];
                    if(nr<0 || nc<0
                    ||nr>=grid.length || nc>=grid[0].length
                    || grid[nr][nc] != Integer.MAX_VALUE)
                        continue;
                    grid[nr][nc] = 1+ grid[r][c];
                    q.add(new int[]{nr,nc});
                }

            }
        }
    }
}
