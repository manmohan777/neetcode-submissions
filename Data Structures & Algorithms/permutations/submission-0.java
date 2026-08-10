class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList();
        backtrack(nums,res,new ArrayList(),new boolean[nums.length]);
        return res;
    }
    void backtrack(int[] nums, List<List<Integer>> res,List<Integer> sublist,boolean[] pick){
        if(sublist.size()==nums.length){
            res.add(new ArrayList(sublist));
            return;
        }
    
        for(int i=0;i<nums.length;i++){
            if(!pick[i]){

                sublist.add(nums[i]);
                pick[i]=true;
                backtrack(nums,res,sublist,pick);
                sublist.remove(sublist.size()-1);
                pick[i]=false;
            }
        }
    }
}
