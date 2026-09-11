class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean dp[][] = new boolean[n][n];
        int res = 0;
        for(int len = 1; len <= n; len++){
            for(int l = 0; l <= n-len; l++){
                int r = l + len - 1;
                dp[l][r] = (s.charAt(l) == s.charAt(r) && ((l+1 > r-1) || dp[l+1][r-1]));
                if(dp[l][r]) res++;
            }
        }
        return res;
    }
}
