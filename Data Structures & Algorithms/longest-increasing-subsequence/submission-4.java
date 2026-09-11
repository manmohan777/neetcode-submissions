class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] mem = new int[nums.length];
        Arrays.fill(mem, -1);
        int res =1;
        for(int i = 0; i<nums.length; i++){
            res=Math.max(res, solve(nums,i,mem));
        }
        return res;
    }
    int solve(int[] nums, int i, int[] mem){
        if(mem[i] != -1) return mem[i];
        int res = 1;
        for(int j=i+1; j < nums.length; j++){
            if(nums[i]<nums[j]){
                res = Math.max(res,1+solve(nums,j,mem));
            }
        }
      
        return mem[i] = res;
    }
}
