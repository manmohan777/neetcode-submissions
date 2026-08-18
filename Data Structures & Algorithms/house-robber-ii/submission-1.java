class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int dp[][] = new int[nums.length][2];
        for(int[] d: dp){
            Arrays.fill(d,-1);
        }
        return Math.max(dfs(nums, 0,1,dp),dfs(nums,1,0,dp));
    }
    int dfs(int[] nums,int i,int flag,int[][] dp){
        if(i>= nums.length || (flag==1 && i==nums.length-1)){
            return 0;
        }
        if(dp[i][flag]!= -1)
            return dp[i][flag];
        return dp[i][flag] = Math.max(dfs(nums,i+1,flag,dp),nums[i]+dfs(nums,i+2,flag,dp));
    }
}
