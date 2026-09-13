class Solution {
    int[][] memo ;
    public int minDistance(String word1, String word2) {
       memo = new int[word1.length()][word2.length()];
       for(int mem[]: memo){
            Arrays.fill(mem, -1);
       }
        return solve(word1, word2, 0,0);
    }
    int solve(String s1, String s2, int i, int j){
        if(i==s1.length()) return s2.length()-j;
        if( j == s2.length()) return s1.length()-i;
        if(memo[i][j] !=-1) return memo[i][j];
        if(s1.charAt(i)==s2.charAt(j)){
            return memo[i][j] = solve(s1,s2,i+1,j+1);
        }else{
            int replace = solve(s1,s2,i+1,j+1);
            int insert = solve(s1,s2,i,j+1);
            int delete = solve(s1,s2,i+1,j);
            return memo[i][j]= 1 + Math.min(replace,Math.min(insert,delete));
        }
    }
}
