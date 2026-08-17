class Solution {
    public int climbStairs(int n) {
        int dp[] = new int[n+2];
        Arrays.fill(dp,-1);
       return dfs(n,0,dp);
    }
    int dfs(int n, int i,int[] dp){
       
        if(i>=n){
            dp[i] = i==n?1:0;
            return dp[i];
        }
         if(dp[i]!=-1)
        return dp[i];
        return dp[i] = dfs(n,i+1,dp)+dfs(n,i+2,dp);
    }
}
