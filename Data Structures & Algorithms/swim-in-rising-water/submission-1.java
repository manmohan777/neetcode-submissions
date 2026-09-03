public class Solution {
    public int swimInWater(int[][] grid) {
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        int N = grid.length;
        boolean[][] visited = new boolean[N][N];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[0]-b[0]);
        pq.add(new int[]{grid[0][0],0,0});
        visited[0][0] = true;
        while(!pq.isEmpty()){
            int[] current = pq.poll();
            int t = current[0];
            int r = current[1];
            int c = current[2];
           
            if(r == N-1 && c == N-1) return t;
            for(int[] dir : dirs){
                int nr=r+dir[0];
                int nc=c+dir[1];

                if(nr >= 0 && nc >= 0 && nr < N && nc < N && !visited[nr][nc]){
                    visited[nr][nc] = true;
                    pq.add(new int[]{
                        Math.max(t,grid[nr][nc]),
                        nr,
                        nc});
                }
            }
        }
        return N*N;
    }
}