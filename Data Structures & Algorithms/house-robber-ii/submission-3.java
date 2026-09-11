class Solution {
    public int rob(int[] nums) {
        int[] mem = new int[nums.length];
        int[] mem2 = new int[nums.length];
        Arrays.fill(mem, -1);
        Arrays.fill(mem2, -1);
        return Math.max(solve(nums, 0, nums.length-1,mem),solve(nums, 1, nums.length,mem2));
    }

    int solve(int[] nums , int i, int n, int[] mem){
        if(n==0) return nums[n];
        if(i>= n) return 0;
        if(mem[i]!= -1) return mem[i];
        return mem[i] = Math.max(nums[i] + solve(nums, i+2, n, mem), solve(nums, i+1, n, mem));
    }
}
