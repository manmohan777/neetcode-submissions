class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums){
            sum+=num;
        }
        if(sum%2 ==1) return false;
        Map<String,Boolean> mem = new HashMap<>();
        
        return solve(nums,sum/2,0,mem);
    }
    boolean solve(int[] nums,int sum, int i, Map<String,Boolean> mem){
        if(sum == 0) return true;
        if(i>=nums.length || sum<0) return false;
        if(mem.containsKey(i+""+sum)) return mem.get(i+""+sum);
        boolean take = solve(nums,sum-nums[i], i+1, mem);
        boolean skip = solve(nums,sum,i+1, mem);
        boolean res = take||skip;
        mem.put(i+""+sum,res);
        return res;
    }
}
