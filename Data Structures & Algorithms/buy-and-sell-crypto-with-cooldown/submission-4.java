class Solution {
    Map<String, Integer> memo;
    public int maxProfit(int[] prices) {
        memo = new HashMap<>();
        return solve(prices,0,false);
    }

    int solve(int[] prices, int i, boolean canSell){
        if(i>= prices.length) return 0;
        String key = i+" "+canSell;
        if(memo.containsKey(key)) return memo.get(key);
        int skip = solve(prices, i+1, canSell);
        int res = skip;
        if(canSell){
            int buy = solve(prices, i+2,false) + prices[i];
            res =  Math.max(skip,buy);
        }else{
            int sell = solve(prices, i+1,true) - prices[i];
            res =  Math.max(skip,sell);
        }
        memo.put(key,res);
        return res;
    }
 
}
