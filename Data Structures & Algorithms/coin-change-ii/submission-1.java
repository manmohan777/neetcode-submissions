class Solution {
    public int change(int amount, int[] coins) {
        Map<String,Integer> memo = new HashMap();
        return dfs( coins, amount,0,memo);
    }
    int dfs(int[] coins, int amount, int i, Map<String, Integer> memo) {
        if(i>= coins.length) return 0;
        if(amount <0) return 0;
        if(amount == 0) return 1;
        String key = i+"-"+amount;
        if(memo.containsKey(key)) return memo.get(key);
        int take = dfs(coins, amount-coins[i], i, memo);
        int skip = dfs(coins,amount, i+1, memo);
        int res= take+skip;
        memo.put(key, res);
        return res;
    }
}
