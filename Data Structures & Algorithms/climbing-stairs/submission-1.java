class Solution {
    public int climbStairs(int n) {
        if(n==1)
        return 1;
        int[] dp = new int[n];
        dp[n-1]=1;
        dp[n-2] = 2;
        int i=n-3;
        while(i>=0){
            dp[i]=dp[i+1]+dp[i+2];
            i--;
        }
        return dp[0];
    }
}
