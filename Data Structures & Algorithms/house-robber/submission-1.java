class Solution {
    public int rob(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp,-1);
        return Math.max(dfs(nums,0,dp),dfs(nums,1,dp));
    }
    int dfs(int[] nums, int i, int dp[]){
        if(i>=nums.length) return 0;
        if(dp[i]!=-1) return dp[i];
        return dp[i] = nums[i]+Math.max(dfs(nums,i+2,dp), dfs(nums,i+3,dp));
    }
}
