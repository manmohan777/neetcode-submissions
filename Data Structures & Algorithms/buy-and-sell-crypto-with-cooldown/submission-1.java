class Solution {
    public int maxProfit(int[] prices) {
        int[][] memo = new int[prices.length][2];
        for(int[] mem : memo) {
            Arrays.fill(mem, -1);
        }
        return dfs(prices,0,true, memo);
    }
    int dfs(int[] prices, int i, boolean canBuy, int memo[][]){
        if( i>= prices.length){
             return 0;
        }
        int tf= canBuy?1:0;
        if(memo[i][tf] != -1) return memo[i][tf];
        if(canBuy){
            int take =  dfs(prices, i+1, false, memo) - prices[i];
            int skip = dfs(prices, i+1, true, memo);
            return memo[i][tf] = Math.max(take, skip);
        }else{
            int sell = dfs(prices, i+2, true, memo) + prices[i];
            int skip = dfs(prices, i+1, false, memo);
            return memo[i][tf] = Math.max(sell, skip);
        }
    }
}
