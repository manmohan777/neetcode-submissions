class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int num: nums){
            sum+= num;
        }
        if(sum%2==1) return false;
        return dfs(nums,sum/2,0);
    }
    boolean dfs(int[] nums,int sum, int i){
        if(sum==0) return true;
        if(i>=nums.length || sum < 0) return false;
        return dfs(nums,sum-nums[i],i+1)|| dfs(nums,sum,i+1);

    }
    
}
