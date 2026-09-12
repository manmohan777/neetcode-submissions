class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        // a+b=sum
        // a-b=target
        // 2a =sum+target
        // a = sum+target/2
        int sum = 0;
        for(int num: nums){
            sum +=num;
        }
        if (Math.abs(target) > sum || (sum + target) % 2 != 0) {
            return 0;
        }

        int targetSum = (target+sum)/2;
        Map<String,Integer> memo = new HashMap();
      
        return solve(nums,targetSum,0,memo);
    }
    int solve(int[] nums, int sum, int i, Map<String,Integer> memo){
        if(i==nums.length) return sum==0?1:0;
        if(sum<0 ) return 0;
        String key = i+" "+sum;
        if(memo.containsKey(key)) return memo.get(key);
        int res  =   solve(nums, sum, i+1, memo);
        if(sum>=nums[i])
             res += solve(nums, sum-nums[i],i+1,memo);
        memo.put(key,res);
        return res;
    }
}
