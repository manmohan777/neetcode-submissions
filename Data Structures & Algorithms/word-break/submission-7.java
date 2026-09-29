class Solution {
    Map<Integer, Boolean> memo;
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet();
        memo = new HashMap<>();
        for(String word: wordDict){
            set.add(word);
        }
        return solve(s,0,set);
    }
    boolean solve(String s, int i, Set<String> set ){
        if(i==s.length()) return true;
        if(memo.containsKey(i)) return memo.get(i);
        for(int j = i+1; j<=s.length(); j++){
            if(set.contains(s.substring(i,j))){
                if(solve(s,j,set)){ 
                    memo.put(i,true);
                    return true;
                }
            }
        }
        memo.put(i,false);
        return false;
    }

}
