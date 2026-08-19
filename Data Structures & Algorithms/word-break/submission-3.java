class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> map = new HashSet();
        int dp[][] = new int[s.length()+1][s.length()+1];
        for(int[] d: dp){
            Arrays.fill(d,-1);
        }
        for(String word: wordDict){
            map.add(word);
        }
        return dfs(s,0,map,dp);
    }
    boolean dfs(String s, int i, Set<String> map, int[][] dp){
        if(i==s.length())
            return true;
        for(int j=i+1 ; j<=s.length(); j++){
            String current= s.substring(i,j);
            if(map.contains(current)){
                if(dp[i][j]!=-1)
                    return dp[i][j]==1;
                    
                dp[i][j] = dfs(s,j,map,dp)?1:0;
                if(dp[i][j]==1) 
                    return true;
            }
        }
        return false;
    }
}
