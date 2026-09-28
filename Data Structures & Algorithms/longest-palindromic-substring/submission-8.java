class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int length=0;
        int ind=0;
        for(int len = 0; len< n; len++){
            for(int l = 0; l< n-len; l++){
                int r = l + len;
                if(s.charAt(l)== s.charAt(r) && ((len < 2) || dp[l+1][r-1])){
                    dp[l][r] = true;
                    if(len>length){
                        length = len;
                        ind = l;
                    }
                }
            }
        }
        return s.substring(ind,ind+length+1);
    }
}
