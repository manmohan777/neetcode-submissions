class Solution {
    int[] memo;
    public int climbStairs(int n) {
        memo = new int[n+1];
        Arrays.fill(memo, -1);
        return solve(1, n);
    }
    int solve(int i, int n){
        if(i>=n) return 1;
        if(memo[i]!=-1) return memo[i];
        return memo[i] = solve(i+1,n)+solve(i+2,n);
    }
}
