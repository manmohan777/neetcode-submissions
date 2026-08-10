class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList();
        backtrack(nums,0,new ArrayList<Integer>(),res);
        return res;
    }
    void backtrack(int[] nums,int i,List<Integer> sublist,List<List<Integer>> res){
        if(i==nums.length){
            res.add(new ArrayList(sublist));
            return;
        }
        sublist.add(nums[i]);
        backtrack(nums,i+1,sublist,res);
        sublist.remove(sublist.size()-1);
        backtrack(nums,i+1,sublist,res);
    }
}
