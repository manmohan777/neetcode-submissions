class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean dp[][] = new boolean[n][n];
        String res = "";
        for(int length = 1; length <= n; length++){
            for(int l = 0; l <= n-length; l++ ){
                int r = l+length-1;
                dp[l][r] = (s.charAt(l) == s.charAt(r) && ((l+1 > r-1) || dp[l+1][r-1]));
                if(dp[l][r] && r-l+1>res.length()){
                    res= s.substring(l,r+1);
                }
            }
        }
        return res;
    }
}
