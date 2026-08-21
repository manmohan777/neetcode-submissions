class Solution {
    public int minDistance(String word1, String word2) {
        int[][] memo = new int[word1.length()][word2.length()];
        for(int mem[] : memo){
            Arrays.fill(mem, -1);
        }
        return dfs(word1, word2, 0, 0, memo);
    }
    int dfs(String word1, String word2, int i, int j, int[][] memo){
        if(i==word1.length()) return word2.length() - j;
        if(j==word2.length()) return word1.length() - i;
        if(memo[i][j] != -1) return memo[i][j];
        if(word1.charAt(i) == word2.charAt(j))
            return memo[i][j] = dfs(word1, word2, i+1, j+1, memo);
        int insert = 1 + dfs(word1, word2, i, j+1, memo);
        int delete = 1 + dfs(word1, word2, i+1, j, memo);
        int replace = 1 + dfs(word1, word2, i+1, j+1, memo);
        return memo[i][j] =  Math.min(insert,Math.min(delete, replace));
    }
}
