class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList();
        backtrack(nums,0,res,new ArrayList());
        return res;
    }
    void backtrack(int[] nums, int i, List<List<Integer>> res, List<Integer> sublist){
        if(i==nums.length){
            res.add(new ArrayList(sublist));
            return;
        }
        sublist.add(nums[i]);
        backtrack(nums,i+1,res,sublist);
        sublist.remove(sublist.size()-1);
        while(i<nums.length-1 && nums[i]==nums[i+1]){
            i++;
        }
        backtrack(nums,i+1,res,sublist);
    }
}
