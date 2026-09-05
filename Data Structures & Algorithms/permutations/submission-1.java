class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        boolean visited[] = new boolean[nums.length];
        backtrack(nums, visited, new ArrayList(), res);
        return res;
    }

    void backtrack(int[] nums,boolean[] visited, List<Integer> sublist, List<List<Integer>> res){
        if(sublist.size() == nums.length){
            res.add(new ArrayList(sublist));
        }
        for(int j = 0; j< nums.length; j++){
            if(!visited[j]){
                visited[j]=true;
                sublist.add(nums[j]);
                backtrack(nums, visited, sublist, res);
                visited[j] = false;
                sublist.remove(sublist.size()-1);
            }
        }
    }
}
