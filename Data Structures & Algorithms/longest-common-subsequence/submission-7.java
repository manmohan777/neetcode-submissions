class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] memo = new int[text1.length()][text2.length()];
        for(int mem[]: memo){
                Arrays.fill(mem, -1);
        }
        return solve(text1,text2, 0,0, memo);
    }
    int solve(String s1, String s2, int i, int j, int[][] memo){
        if(i >= s1.length() || j >= s2.length()) return 0;
        if(memo[i][j] != -1) return memo[i][j];
        int skipI = solve(s1, s2, i+1,j, memo);
        int skipJ = solve(s1, s2, i,j+1, memo);
        int res = Math.max(skipI,skipJ);
        if(s1.charAt(i) == s2.charAt(j)){
            int skipBoth = 1+ solve(s1, s2, i+1,j+1, memo);
            res = Math.max(skipBoth,res);
        }
        return memo[i][j] = res;

    }
}
