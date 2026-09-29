class Solution {
    Map<Integer, Integer> memo;
    public int lengthOfLIS(int[] nums) {
        memo = new HashMap<>();
        int max = 0;
        for(int i = 0; i< nums.length; i++){
            max = Math.max(solve(nums,i),max);
        }
       return max;
    }
    int solve(int nums[],int i){
        if(memo.containsKey(i)) return memo.get(i);
        int max = 1;
        for(int j = i+1; j< nums.length; j++){
            if(nums[j]>nums[i]){
                max = Math.max(1 + solve(nums, j), max);
            }
        }
        memo.put(i,max);
        return max;
    }
}
