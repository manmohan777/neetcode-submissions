class Solution {
    public int maxCoins(int[] nums) {
        Set<Integer> visited= new HashSet();
        int[] newNums = new int[nums.length+2];
        newNums[0] = newNums[newNums.length-1] = 1;
        for(int i=0; i< nums.length; i++){
            newNums[i+1] = nums[i];
        }
        int[][] memo = new int[newNums.length][newNums.length];
        for(int mem[] : memo){
            Arrays.fill(mem, -1);
        }
        return dfs(newNums,1,newNums.length-2,memo);
    }
    int dfs(int[] nums, int l,int r, int[][] memo){
        if(l > r ) return 0;
        if(memo[l][r] != -1) return memo[l][r];
        memo[l][r] = 0;
        for(int i=l; i<= r; i++){
            int current = nums[l-1]* nums[i]* nums[r+1];
            current = current + dfs(nums,l,i-1, memo)+dfs(nums,i+1,r, memo);
            memo[l][r] =Math.max(memo[l][r], current);

        }
        return memo[l][r];
    }
}
