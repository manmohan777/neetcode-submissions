class Solution {
    public int rob(int[] nums) {
        int mem[] = new int[nums.length];
        Arrays.fill(mem, -1);
        return Math.max(solve(nums, 0, mem),solve(nums,1, mem));
    }
    int solve(int nums[], int i, int[] mem){
        if(i >= nums.length) return 0;
        if(mem[i] != -1) return mem[i];
        return mem[i] = Math.max(nums[i] + solve(nums, i+2, mem),solve(nums, i+1, mem));
    }
}
