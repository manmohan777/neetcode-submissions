class Solution {
    public int maxProfit(int[] prices) {
        Map<String, Integer> mem= new HashMap();
        return solve(prices,0,true,mem);

    }
    int solve(int[] prices, int i, boolean isPurchased, Map<String,Integer> mem){
        if(i >= prices.length) return 0;
        String key = i+""+isPurchased;
        if(mem.containsKey(key)) return mem.get(key);
        int skip =solve(prices, i+1, isPurchased,mem);
        if(isPurchased){
            int sell= solve(prices,i+1,false,mem)-prices[i];
            int res = Math.max(skip,sell);
            mem.put(key,res);
            return res;
        }else{
            int buy = solve(prices,i+2,true,mem) +prices[i];
            int res = Math.max(skip,buy);
            mem.put(key,res);
            return res;
        }
    }
}
