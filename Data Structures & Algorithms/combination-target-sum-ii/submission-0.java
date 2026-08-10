class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {                  
        Arrays.sort(candidates);
        List<List<Integer>> res=new ArrayList();
        backtrack(candidates,target,0,new ArrayList<Integer>(),res);
        return res;
    }
    void backtrack(int[] can, int target,int i,List<Integer> sublist,List<List<Integer>> res){
        if(target==0){
            res.add(new ArrayList(sublist));
            return;
        }
        if(target<0||i>=can.length)
            return;

        sublist.add(can[i]);
        backtrack(can,target-can[i],i+1,sublist,res);
        sublist.remove(sublist.size()-1);
        while(i<can.length-1 && can[i]==can[i+1])
            i++;
        backtrack(can,target,i+1,sublist,res);
    }
}
