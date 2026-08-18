class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean dp[][] = new boolean[n][n];
        int res=0;
        for(int len=1;len<=n;len++){
            for(int i = 0; i<=n-len; i++){
                int j=i+len-1;
                if(s.charAt(i) == s.charAt(j) && (len<=2 || dp[i+1][j-1])){
                    res++;
                    dp[i][j] = true;
                }
            }
        }
        return res;
    }
}
