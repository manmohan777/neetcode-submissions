class Solution {
    public List<List<String>> partition(String s) {
        int n=s.length();
        boolean[][] dp = new boolean[n][n];
        List<List<String>> res= new ArrayList();
        for(int l=1;l<=n;l++){
            for(int i=0;i<=n-l;i++){
                dp[i][i+l-1]=(s.charAt(i)==s.charAt(i+l-1))  &&((i+1>i+l-2) || dp[i+1][i+l-2]);
            }
        }
        dfs(0,s,res,new ArrayList(),dp);
        return res;

    }

    void dfs(int i,String s,List<List<String>> res, List<String> part,boolean[][] dp){
        if(i>=s.length()){
            res.add(new ArrayList(part));
            return;
        }
        for(int j=i;j<s.length();j++){
            if(dp[i][j]){
                part.add(s.substring(i,j+1));
                dfs(j+1,s,res,part,dp);
                part.remove(part.size()-1);
            }
        }
    }
}
