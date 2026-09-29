public class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int curMin = 1, curMax = 1;
        for(int num: nums){
            int tmpMin  = num * curMin;
            int tmpMax = num * curMax; 
            curMax  = Math.max(Math.max(tmpMax, tmpMin),num);
            curMin  = Math.min(Math.min(tmpMax, tmpMin),num);
            res = Math.max(curMax, res);
        }
        return res;
    }
}