class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int length=0;
        int ind=0;
        for(int len = 1; len<=n ; len++){
            for(int i=0; i<=n-len; i++){
                int j=i+len-1;
                if(s.charAt(i)==s.charAt(j) && (len<=2 || dp[i+1][j-1])){
                    dp[i][j]= true;
                    if(length<len){
                        length=len;
                        ind=i;
                    }
                }
              
            }
        }
        // for(boolean d[] : dp){
        //     for(boolean p : d){
        //         System.out.print(p+",");
        //     }
        //     System.out.println("\n");
        // }
        return s.substring(ind,ind+length);
    }
}
