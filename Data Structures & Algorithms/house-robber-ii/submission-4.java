class Solution {
    Map<String, Integer> memo;
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        memo = new HashMap<>();
        return Math.max(solve(nums, 0,false),solve(nums,1,true));
    }
    int solve(int[] nums,int i,boolean takeLast){
        if(takeLast && i>= nums.length) return 0;
        if(!takeLast && i>=nums.length-1) return 0;
        String key = i+" "+takeLast;
        if(memo.containsKey(key)) return memo.get(key);
        int take = nums[i] + solve(nums, i+2,takeLast);
        int skip = solve(nums, i+1,takeLast);
        int res = Math.max(take, skip);
        memo.put(key, res);
        return res;
    }
}
