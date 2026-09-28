class Solution {
    Map<Integer, Integer> memo;
    public int climbStairs(int n) {
        memo = new HashMap<>();
        return solve(1, n);
    }
    int solve(int i, int n){
        if(i>=n) return 1;
        if(memo.containsKey(i)) return memo.get(i);
        int res = solve(i+1,n)+solve(i+2,n);
        memo.put(i,res);
        return res;
    }
}
