class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean dp[][] = new boolean[n][n];
        int res=0;
        for(int i=0; i<n; i++){
            res +=findLength(s,i,i);
            res+=findLength(s,i,i+1);
        }
        return res;
    }
    int findLength(String s, int i, int j){
        int res=0;
        while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)){
            res++;
            i--;
            j++;
        }
        return res;
    }
}
