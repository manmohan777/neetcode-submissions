class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res= new ArrayList();
        backtrack(nums,target,0,res, new ArrayList());
        return res;
    }
   void backtrack(int[] nums, int target, int i, List<List<Integer>> res, List<Integer> sublist){
    if(target==0){
        res.add(new ArrayList(sublist));
        return;
    }
    // System.out.println(i);
    if(target< 0 || i >= nums.length) return;
    sublist.add(nums[i]);
    backtrack(nums, target-nums[i], i, res, sublist);
    sublist.remove(sublist.size()-1);
    backtrack(nums, target, i+1, res, sublist);
   }
}
