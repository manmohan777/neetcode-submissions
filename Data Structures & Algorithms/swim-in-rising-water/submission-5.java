class Solution {
    public int swimInWater(int[][] grid) {
        int[][] dirs = {{-1,0}, {1,0}, {0,-1},{0,1}};
        int n = grid.length, m = grid[0].length;
        
        int visited[][] = new int[n][m];
        for(int[] vis: visited){
            Arrays.fill(vis,Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2]-b[2]);
        pq.add(new int[]{0,0,grid[0][0]});
        visited[0][0] = grid[0][0];
        while(!pq.isEmpty()){
            int[] current = pq.poll();
            int r = current[0];
            int c = current[1];
            int level = current[2];
            if(r == n-1 && c == n-1) return level;
            for(int dir[]: dirs){
                int nr = r+dir[0], nc = c+dir[1];
                if(nr >= 0 && nc >= 0 && nr < n && nc < m ){
                    int nextMinLevel = Math.max(level,grid[nr][nc]);
                        if(nextMinLevel<visited[nr][nc]){
                            visited[nr][nc] = nextMinLevel;
                            pq.add(new int[]{nr,nc,nextMinLevel});
                        }
                    
                }
            }
        }
        return n*n;
    }
}
