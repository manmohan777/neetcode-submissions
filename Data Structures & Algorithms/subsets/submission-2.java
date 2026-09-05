class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res=new ArrayList();
        backTrack(nums, 0,res,new ArrayList<Integer>());
        return res;
    }
    void backTrack(int[] nums,int i, List<List<Integer>> res, List<Integer> sublist){
        if(i == nums.length){
            res.add(new ArrayList(sublist));
            return;
        }
        sublist.add(nums[i]);
        backTrack(nums,i+1,res,sublist);
        sublist.remove(sublist.size()-1);
        backTrack(nums,i+1,res,sublist);
    }
}
