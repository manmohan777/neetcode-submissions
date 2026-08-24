class Solution {
    public boolean canJump(int[] nums) {
        int memo[] = new int[nums.length];
        Arrays.fill(memo, -1);
        return dfs(nums, 0,memo);
    }
    boolean dfs(int[] nums, int i, int[] memo){
        if(i>=nums.length-1) return true;
        if(memo[i] != -1) return memo[i]==1;
        int j=nums[i];
        while(j>0){
            if(dfs(nums,i+j, memo)){
                memo[i]=1;
                return true;
            }
            else{
                memo[i]= 0;
            }
            j--;
        }
        memo[i] = 0;
        return false;
    }

    
}
