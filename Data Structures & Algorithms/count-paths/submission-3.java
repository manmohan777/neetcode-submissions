class Solution {
    public int uniquePaths(int m, int n) {
     
      int[][] memo = new int[m][n];
      for(int[] mem: memo){
        Arrays.fill(mem,-1);
      }
      return solve(0,0,m,n,memo);  
    }
    int solve(int r, int c, int m, int n,int[][] memo){
        if(r<0||c<0||r>=m||c>=n) return 0;
        if(r == m-1 && c == n-1) return 1;
        if(memo[r][c] != -1) return memo[r][c];
        return memo[r][c] = solve(r+1,c,m,n,memo) + solve(r,c+1,m,n,memo);
    }
}
