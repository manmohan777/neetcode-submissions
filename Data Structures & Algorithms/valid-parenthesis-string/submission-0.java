class Solution {
    public boolean checkValidString(String s) {
        Boolean[][] memo = new Boolean[s.length()][s.length()];
        return dfs(s, 0,0, memo);
    }
    boolean dfs(String s, int open, int i, Boolean[][] memo){
        if(i==s.length()) {
            return open==0;
        }
        if(open<0 ) return false;
        if(memo[i][open] != null) return memo[i][open];
        if(s.charAt(i) == '(') return memo[i][open] = dfs(s,open+1,i+1, memo);
         if(s.charAt(i) == ')') return memo[i][open] =dfs(s,open-1,i+1, memo);
        else{
           return memo[i][open] = ( dfs(s,open+1,i+1, memo) || dfs(s,open-1,i+1, memo)||dfs(s,open,i+1, memo)) ;
        }
        
    }
}
