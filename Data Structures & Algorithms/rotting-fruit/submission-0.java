class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> q = new LinkedList();
        int dir[][]={{1,0},{-1,0},{0,1},{0,-1}};
        int freshCount=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }
                if(grid[i][j]==1)
                    freshCount++;
            }
        }
        if(freshCount==0) return 0;
        int steps=0;
        while(!q.isEmpty() && freshCount > 0 ){
            int size=q.size();
            for(int i=0;i<size;i++){
                int cur[]=q.poll();
                int r=cur[0],c=cur[1];
                for(int[] d: dir){
                    int nr = r+d[0];
                    int nc = c+d[1];
                    if( nr >= 0 && nc>=0 &&
                    nr < rows && nc < cols &&
                    grid[nr][nc] == 1 ){
                        grid[nr][nc]=2;
                        q.add(new int[]{nr,nc});
                        freshCount--;
                    }
                }
            }
            steps++;
        }
        return freshCount==0 ? steps : -1;
    }
}
