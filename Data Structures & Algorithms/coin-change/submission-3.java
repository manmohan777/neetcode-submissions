class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] memo = new int[amount+1];
        Arrays.fill(memo,-1); 
        int res = solve(coins, amount,memo);
        return res == Integer.MAX_VALUE? -1: res;
    }

    int solve(int[] coins, int amount,int[] mem){
        if(amount ==0) return 0;
        if(amount < 0) return  Integer.MAX_VALUE;
        int minCoins = Integer.MAX_VALUE;
        if(mem[amount]!=-1) return mem[amount];
        for(int i = 0; i< coins.length; i++){
            int res = solve(coins, amount-coins[i], mem);
            if(res!=Integer.MAX_VALUE){
                minCoins = Math.min(res+1, minCoins);
            }
        }
        return mem[amount] = minCoins;

    }
}
