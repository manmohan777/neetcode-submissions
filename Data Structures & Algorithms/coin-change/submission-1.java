class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount+1];
        Arrays.fill(dp,-1);
        int res= dfs(coins,amount,dp);
        return res==Integer.MAX_VALUE? -1: res;
    }
    int dfs(int[] coins, int amount, int[] dp){
        if(amount== 0) return 0;
        if(amount < 0 ) return Integer.MAX_VALUE;
        int minCoins = Integer.MAX_VALUE;
        if(dp[amount]!=-1) return dp[amount];
        for(int i=0;i<coins.length; i++){
            int res= dfs(coins,amount-coins[i],dp);
            if(res!=Integer.MAX_VALUE){
                minCoins=Math.min(res+1,minCoins);
            }
        }
        
        return dp[amount] = minCoins;
        
    }
}
