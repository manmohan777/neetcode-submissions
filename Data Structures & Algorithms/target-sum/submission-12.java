class Solution {
    Map<String, Integer> memo;
    public int findTargetSumWays(int[] nums, int target) {
        memo = new HashMap<>();
        int sum= 0;
        for(int num: nums){
            sum+=num;
        }
       
        //     s1+s2 = sum       s2 is subset1 and s2 is subset2
        //  +  s1-s2 = target
        //     --------------
        //     2s1 = sum+target
        //     s1 = sum + target /2   
        //    so need to find subsets whose sum is (sum+targer)/2;
        if (Math.abs(target) > sum || (sum + target) % 2 != 0) {
            return 0;
        }
        int newtarget = (sum + target)/2;
     
        return solve(nums,0,newtarget);
    }
    int solve(int[] nums, int i, int sum){
        if(i >= nums.length  ) return sum==0 ? 1: 0;
        if(sum < 0) return 0;
        String key = i+" "+ sum;
        if(memo.containsKey(key)) return memo.get(key);
        int take = solve(nums, i+1, sum-nums[i]);
        int skip = solve(nums, i+1, sum);
        int res = take+skip;
        memo.put(key,res);
        return res;
    }

}
