class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> map = new HashSet();
        int dp[] = new int[s.length()+1];
        Arrays.fill(dp,-1);
        
        for(String word: wordDict){
            map.add(word);
        }
        return dfs(s,0,map,dp);
    }
    boolean dfs(String s, int i, Set<String> map, int[] dp){
        if(i==s.length())
            return true;
        if(dp[i]!=-1)
            return dp[i]==1;
        for(int j=i+1 ; j<=s.length(); j++){
            String current= s.substring(i,j);
            if(map.contains(current)){
                dp[i] = dfs(s,j,map,dp)?1:0;
                if(dp[i]==1) 
                    return true;
            }
        }
        dp[i] = 0;
        return  false;
    }
}
