class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res=new ArrayList();
        backtrack(nums,target,0,new ArrayList<Integer>(),res);
        return res;
    }
    void backtrack(int[] nums,int target,int i,ArrayList<Integer> sublist,List<List<Integer>> res){
        if(target==0){
            res.add(new ArrayList(sublist));
            return;
        }
        else if(target<0 || i==nums.length){
            return;
        }
        sublist.add(nums[i]);
        backtrack(nums,target-nums[i],i,sublist,res);
        sublist.remove(sublist.size()-1);
        backtrack(nums,target,i+1,sublist,res);
    }
}
