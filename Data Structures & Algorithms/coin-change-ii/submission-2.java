class Solution {
    public int change(int amount, int[] coins) {
        int memo[][] = new int[coins.length+1][amount+1];
        for(int[] mem : memo) {
            Arrays.fill(mem,-1);
        }
        return dfs( coins, amount,0,memo);
    }
    int dfs(int[] coins, int amount, int i,int[][] memo) {
        if(i>= coins.length) return 0;
        if(amount <0) return 0;
        if(amount == 0) return 1;
        
        if(memo[i][amount]!=-1) return memo[i][amount];
        int take = dfs(coins, amount-coins[i], i, memo);
        int skip = dfs(coins,amount, i+1, memo);
        return memo[i][amount] = take+skip;
    }
}
