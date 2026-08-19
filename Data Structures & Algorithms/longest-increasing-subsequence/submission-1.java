class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length+1];
        Arrays.fill(dp,-1);
        int max = 1;
        for(int i=0;i<nums.length; i++){
            max=Math.max(max,dfs(nums,i,dp));
        }
       return max;
    }
    int dfs(int nums[],int i,int[] dp){
        if(i==nums.length) return 0;
        int max=1;
        if(dp[i]!=-1)
            return dp[i];
            for(int j=i+1; j< nums.length; j++){
                if(nums[i]<nums[j]){
                    max = Math.max(1+dfs(nums, j,dp),max);
                }
            }
        dp[i]= max;
        return dp[i] = max;
    }
}
