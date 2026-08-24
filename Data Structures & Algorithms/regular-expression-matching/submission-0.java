class Solution {
    public boolean isMatch(String s, String p) {
        int[][] memo = new int[s.length()+1][p.length()+1];
        for(int mem[] : memo){
            Arrays.fill(mem, -1);
        }
        return dfs(0, 0, s, p,memo);
        
    }
    boolean dfs(int i, int j, String s, String p, int memo[][]){
        if(j==p.length()) return i==s.length();

        if(memo[i][j]!= -1) return memo[i][j] ==1;
        boolean match = i < s.length() &&
         (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
        if(j+1 < p.length() && p.charAt(j+1) == '*'){
            boolean res = dfs(i, j+2, s, p, memo) ||(match && dfs(i+1, j, s, p, memo));
            if(res)
                memo[i][j] =1;
            else
                memo[i][j] =0;
            return res;
        }
        if(match){
            boolean res =  dfs(i+1, j+1, s, p, memo);
            if(res)
                memo[i][j] =1;
            else
                memo[i][j] = 0;
            return res; 
        }
        memo[i][j] = 0;
        return false;
    }
}
