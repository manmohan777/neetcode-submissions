class Solution {
    Map<Integer, Integer> memo;
    public int rob(int[] nums) {
        memo = new HashMap<>();
        return solve(nums, 0);
    }

    int solve(int[] nums, int i){
        if(i>= nums.length) return 0;
        if(memo.containsKey(i)) return memo.get(i);
        int take =  nums[i]+ solve(nums, i+2);
        int skip = solve(nums,i+1);
        int res = Math.max(take,skip);
        memo.put(i,res);
        return res;
    }
}
