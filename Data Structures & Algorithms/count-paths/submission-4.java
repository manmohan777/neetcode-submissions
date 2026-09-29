class Solution {
    int[][] dp;
    public int uniquePaths(int m, int n) {
        dp = new int[m][n];
        for(int d[] : dp)
            Arrays.fill(d,-1);
        return solve(m,n, 0, 0);
    }

    int solve(int m, int n, int r, int c){
        if(r>=m || c >= n) return 0;
        if(r== m-1 && c == n-1)return 1;
        if(dp[r][c] !=-1) return dp[r][c];
        return dp[r][c] = solve(m, n, r+1, c) + solve(m, n, r, c+1);
    }
}
