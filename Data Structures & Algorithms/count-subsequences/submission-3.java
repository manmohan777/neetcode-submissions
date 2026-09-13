class Solution {
    int[][] memo;
    public int numDistinct(String s, String t) {
        memo = new int[s.length()][t.length()];
        for(int mem[]: memo){
            Arrays.fill(mem, -1);
        }
        return solve(s, t, 0,0);
    }
    int solve(String s, String t, int i, int j){
        if(i==s.length()){
            return j==t.length()? 1:0;
        }
        if(j<t.length() && memo[i][j] !=-1) return memo[i][j];
        int res = solve(s,t,i+1,j);
        if(j<t.length() && s.charAt(i) == t.charAt(j)){
            res+=solve(s,t,i+1,j+1);
        }
        if(j<t.length())
        memo[i][j] =res;
        return  res;
    }
}
