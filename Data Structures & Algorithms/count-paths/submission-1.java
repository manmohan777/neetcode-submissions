class Solution {
    public int uniquePaths(int m, int n) {
      int[][] dirs = {{1,0}, {0,1}};
      int[][] memo = new int[m][n];
      for(int[] mem: memo){
        Arrays.fill(mem,-1);
      }
      return solve(0,0,m,n,dirs,new boolean[m][n],memo);  
    }
    int solve(int r, int c, int m, int n,int[][] dirs,boolean[][] visited,int[][] memo){
        if(r<0||c<0||r>=m||c>=n) return 0;
        if(r == m-1 && c == n-1) return 1;
        if(visited[r][c]) return 0;
        if(memo[r][c] != -1) return memo[r][c];
        visited[r][c] = true;
        int res = 0;
        for(int dir[] : dirs){
            int nr = r + dir[0], nc = c + dir[1];
                res += solve(nr,nc,m,n,dirs,visited,memo);
            
        }
        visited[r][c] = false;
        return memo[r][c] = res;
    }
}
