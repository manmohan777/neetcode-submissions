class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet();
        for(String word: wordDict){
            set.add(word);
        }
        Map<Integer, Boolean> mem= new HashMap<>();
        return solve(s,set, 0,mem);
    }
    boolean solve(String s, Set<String> dict, int idx, Map<Integer, Boolean> mem){
        if(idx==s.length()) return true;
        if(mem.containsKey(idx)) return mem.get(idx);
        for(int i=idx; i< s.length(); i++){
            // System.out.println(s.substring(idx,i+1));
            if(dict.contains(s.substring(idx,i+1))){
         
                if(solve(s,dict,i+1,mem)){ 
                    mem.put(idx,true);
                    return true;
                }
            }
        }
        mem.put(idx,false);
        return false;
    }
}
