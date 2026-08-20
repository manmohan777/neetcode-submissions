class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum= 0;
        for(int num: nums){
            sum+=num;
        }
       
       
        //     s1+s2 = sum       s2 is subset1 and s2 is subset2
        //  +  s1-s2 = target
        //     --------------
        //     2s1 = sum+target
        //     s1 = sum + targer /2   
        //    so need to find subsets whose sum is (sum+targer)/2;
        if (Math.abs(target) > sum || (sum + target) % 2 != 0) {
            return 0;
        }
        int newtarget = (sum+target)/2;
        int[][] memo = new int[nums.length+1][newtarget+1];
        for(int mem[] : memo){
            Arrays.fill(mem,-1);
        }
        return dfs(nums,0,newtarget, memo);
    }

    int dfs(int[] nums, int i, int sum, int[][] memo){
        if(i== nums.length ) return sum==0?1:0;
        
        if(memo[i][sum] != -1) return memo[i][sum];

        int take = 0;
        int skip = dfs(nums, i+1, sum, memo);
        if(sum>=nums[i])
             take = dfs(nums, i+1, sum-nums[i],memo);
        
        return memo[i][sum] = take+ skip;
    }
}
