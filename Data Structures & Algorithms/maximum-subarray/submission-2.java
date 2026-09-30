class Solution {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int sum = 0;
        for(int num: nums){
            sum += num;
            res=Math.max(sum,res);
            if(sum<0) sum = 0;
        }
        return res;
    }
   
}
