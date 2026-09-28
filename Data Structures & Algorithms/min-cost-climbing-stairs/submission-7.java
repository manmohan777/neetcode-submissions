class Solution {
    Map<Integer, Integer> memo;
    public int minCostClimbingStairs(int[] cost) {
        memo = new HashMap<>();
        return Math.min(solve(cost, 0),solve(cost,1));
    }
    int solve(int[] cost, int i){
        if(i>=cost.length) return 0;
        if(memo.containsKey(i)) return memo.get(i);
        int res =cost[i] +Math.min(solve(cost,i+1),solve(cost,i+2));
        memo.put(i, res);
        return res;
    }
}
