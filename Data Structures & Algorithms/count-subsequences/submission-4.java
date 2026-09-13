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
        if(j==t.length()) return 1;
        if(i==s.length()) return 0;
             
        
        if( memo[i][j] !=-1) return memo[i][j];
        int res = solve(s,t,i+1,j);
        if( s.charAt(i) == t.charAt(j)){
            res+=solve(s,t,i+1,j+1);
        }
        return memo[i][j] = res;
    }
}
