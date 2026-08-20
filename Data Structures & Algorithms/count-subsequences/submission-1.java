class Solution {
    public int numDistinct(String s, String t) {
        int memo[][] = new int[s.length()][t.length()];
        for(int mem[] : memo){
            Arrays.fill(mem, -1);
        }
        return dfs(s,t,0,0,memo);
    }
    int dfs(String s, String t,int i, int j,int[][] memo){
        if(j==t.length()) return 1;
        if(i>=s.length()) return 0;
        if(memo[i][j]!= -1) return memo[i][j];
        if(s.charAt(i)==t.charAt(j)){
            return memo[i][j] = dfs(s,t,i+1,j+1,memo)+dfs(s,t,i+1,j,memo);
        }else{
            return memo[i][j] = dfs(s,t,i+1,j,memo);
        }
    }
}
