class Solution {
    Map<String, Integer> memo;

    public int change(int amount, int[] coins) {
        memo = new HashMap<>();
        return solve(coins, 0, amount);
   
    }
    int solve(int[] coins, int i, int amount){
        if(amount == 0) return 1;
        if(i >= coins.length || amount < 0 ) return 0;
        String key = i+" "+ amount;
        if(memo.containsKey(key)) return memo.get(key);
        int take = solve(coins, i, amount-coins[i]);
        int skip = solve(coins, i+1, amount);
        int res = take + skip;
        memo.put(key,res);
        return res;

    }

}
