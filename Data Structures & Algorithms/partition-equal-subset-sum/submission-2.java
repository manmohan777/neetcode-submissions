class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        
        for(int num: nums){
            sum+= num;
        }
        if(sum%2==1) return false;
        Map<String,Boolean> dp =new HashMap();
        
        return dfs(nums,sum/2,0,dp);
    }
    boolean dfs(int[] nums,int sum, int i,Map<String,Boolean> dp){
        if(sum==0) return true;
        if(i>=nums.length || sum < 0) return false;
        if(dp.containsKey(i+""+sum)) return dp.get(i+""+sum);
        
         boolean res = dfs(nums,sum-nums[i],i+1,dp)|| dfs(nums,sum,i+1,dp);
         dp.put(i+""+sum,res);
        return res;
    }
    
}
