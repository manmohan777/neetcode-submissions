class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int []dp = new int[cost.length];
        Arrays.fill(dp,-1);
        return Math.min(dfs(cost,0,dp),dfs(cost,1,dp));
    }
    int dfs(int []costs, int i,int[] dp){
        if(i>=costs.length){
            return 0;
        }
        if(dp[i]!=-1)
            return dp[i];
        return dp[i]=costs[i]+Math.min(dfs(costs,i+1,dp),dfs(costs,i+2,dp));
    }
}
