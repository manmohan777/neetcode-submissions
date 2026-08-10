class Solution {
    public int maxProfit(int[] prices) {
        int min= prices[0];
        int res=0;
        for(int price : prices){
            res=Math.max(price-min, res);
            min=Math.min(price, min);
        }
        return res;

    }
}
