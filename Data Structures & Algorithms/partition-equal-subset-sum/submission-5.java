class Solution {
    Map<String, Boolean> memo;
    public boolean canPartition(int[] nums) {
        int sum=0;   
        for(int num: nums){
            sum+= num;
        }
        if(sum%2==1) return false;
        memo = new HashMap<>();
        return solve(nums,0,sum/2);
    }

    boolean solve(int[] nums, int i, int sum){
        if(sum<0) return false;
        if(i>=nums.length ) return sum == 0? true : false;
        String key = i+" "+sum;
        if(memo.containsKey(key)) return memo.get(key);
        boolean take = solve(nums, i+1, sum-nums[i]);
        boolean skip = solve(nums, i+1, sum);
        boolean res = take || skip;
        memo.put(key,res);
        return res;
    }
}
