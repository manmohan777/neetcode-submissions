class Solution {
    public int numDecodings(String s) {
        int dp[] = new int[s.length()];
        Arrays.fill(dp, -1);
        return dfs(s,0,dp);
    }
    int dfs(String s,int i,int[] dp){
        if(i>=s.length()) return 1;
        if(s.charAt(i)=='0'){
            return 0;
        }
        if(dp[i]!= -1)
            return dp[i];
        int res =  dfs(s,i+1,dp);
        if(i+1<s.length()){
            String current= s.substring(i,i+2);
            int cur=Integer.parseInt(current);
            if(cur<=26){
                res+=dfs(s,i+2,dp);
            }
        }
        return dp[i] = res;
    }
}
