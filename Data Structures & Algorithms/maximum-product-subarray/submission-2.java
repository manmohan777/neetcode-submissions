public class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int curMin = 1, curMax = 1;

        for (int num : nums) {
            int tmpMax = curMax * num;
            int tmpMin = curMin * num;
            curMax = Math.max(Math.max(tmpMax, tmpMin), num);
            curMin = Math.min(Math.min(tmpMax, tmpMin), num);
            res = Math.max(res, curMax);
        }
        return res;
    }
}