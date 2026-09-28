class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int length=0;
        int ind=0;
        String res ="";
        for(int i = 0; i< n; i++){
            String s1 = find(s, i, i);
            if(s1.length()>res.length()){
                res = s1;
            }
            String s2 = find(s, i, i+1);
            if(s2.length()>res.length()){
                res = s2;
            }
        }
        return res;
    }

    String find(String s, int i, int j){
        String res="";
        while(i>=0 && j<s.length() && s.charAt(i) == s.charAt(j)){
            res = s.substring(i,j+1);
            i--;
            j++;
        }
        return res;
    }
}
