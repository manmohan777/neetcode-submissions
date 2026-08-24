class Solution {
    public int jump(int[] nums) {
        int memo[] = new int[nums.length];
        Arrays.fill(memo,-1);
        return dfs(nums, 0, memo);
    }
    int dfs(int[] nums, int i, int[] memo){
        if(i>=nums.length-1) return 0;
        if(memo[i] != -1) return memo[i];
        int j=nums[i];
        int res=Integer.MAX_VALUE;
        while(j>0){
            int temp = dfs(nums, i+j, memo);
            if(temp!= Integer.MAX_VALUE){
            res= Math.min(1 + temp,res);
            } 
            j--;
        }
        return memo[i] = res;
    }
}
