class Solution {
    public int uniquePaths(int m, int n) {
      int[][] dirs = {{1,0}, {0,1}};
      int[][] memo = new int[m][n];
      for(int[] mem: memo){
        Arrays.fill(mem,-1);
      }
      return solve(0,0,m,n,dirs,memo);  
    }
    int solve(int r, int c, int m, int n,int[][] dirs,int[][] memo){
        if(r<0||c<0||r>=m||c>=n) return 0;
        if(r == m-1 && c == n-1) return 1;
        if(memo[r][c] != -1) return memo[r][c];
        int res = 0;
        for(int dir[] : dirs){
            int nr = r + dir[0], nc = c + dir[1];
                res += solve(nr,nc,m,n,dirs,memo);
            
        }
        return memo[r][c] = res;
    }
}
