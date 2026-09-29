class Solution {
    Map<Integer, Integer> memo;
    public int coinChange(int[] coins, int amount) {
        memo = new HashMap<>();
        int res = solve(coins, amount);
        return res==Integer.MAX_VALUE? -1 : res;
    }
    int solve(int[] coins, int amount){
        if(amount<0) return Integer.MAX_VALUE;
        if(amount==0) return 0;
        if(memo.containsKey(amount)) return memo.get(amount);
        int res = Integer.MAX_VALUE;
        for(int i =0; i< coins.length; i++){
            int current = solve(coins, amount-coins[i]);
            if(current !=Integer.MAX_VALUE){
                 res = Math.min(res, 1 + current);
            }
           
        }
        memo.put(amount,res);
        return res;
        
    }
}
