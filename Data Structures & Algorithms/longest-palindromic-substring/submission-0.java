class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int length=0;
        int ind=0;
        for(int i=n-1; i>= 0; i--){
            for(int j=i; j<n; j++){
                if(s.charAt(i)==s.charAt(j) && (j-i<=2 ||
                dp[i+1][j-1])){
                    dp[i][j]=true;
                    if(length<j-i+1){
                        ind=i;
                        length= j-i+1;
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
