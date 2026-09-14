class Solution {
    int memo[];
    public int jump(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo,-1);
        return solve(nums, 0);
    }

    int solve(int[] nums, int i){
        if(i== nums.length-1) return 0;
        if(memo[i] != -1) return memo[i];
        int res = Integer.MAX_VALUE;
        int steps = nums[i];
        for (int step = 1; step <= nums[i]; step++) {
            int next = i + step;
            if (next < nums.length) {
                int temp = solve(nums, next);
                if(temp!=Integer.MAX_VALUE)
                    res = Math.min(res,1 + temp);
            }
        }
        return memo[i] = res;
    }
}
