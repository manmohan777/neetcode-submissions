class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList();
        Arrays.sort(candidates);
        backtrack(candidates,target,0,new ArrayList(),res);
        return res;
    }
   void backtrack(int[] candidates, int target, int i, List<Integer> sublist, List<List<Integer>> res){
    if(target == 0){
        res.add(new ArrayList<Integer>(sublist));
        return;
    }
    if(target < 0 || i>= candidates.length) return;
    sublist.add(candidates[i]);
    backtrack(candidates, target-candidates[i], i+1,sublist, res);
    while(i<candidates.length-1 && candidates[i]==candidates[i+1])
            i++;
    sublist.remove(sublist.size()-1);
    backtrack(candidates, target, i+1,sublist, res);
   }
}
