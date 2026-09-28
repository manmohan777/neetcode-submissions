class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean dp[][] = new boolean[n][n];
        int res = 0;
        for(int len = 0; len<n; len++){
            for(int l = 0; l< n-len; l++){
                int r = l+len;
                if(s.charAt(l) == s.charAt(r) && ((len<2 || dp[l+1][r-1]))){
                    dp[l][r] = true;
                    res++;
                }
            }
        }
      
        return res;
    }
}
