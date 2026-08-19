class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dirs={{0,1},{1,0}};
        boolean visited[][] = new boolean[m][n];
        int memo[][] = new int[m][n];
        for(int mem[]: memo){
            Arrays.fill(mem,-1);
        }
        return dfs(0,0,m,n,dirs,visited,memo);
    }
    int dfs(int i,int j,int m, int n, int[][] dirs,boolean visited[][],int[][] memo){
        if(i<0||j<0||i>=m||j>=n) return 0;
        if(i==m-1 && j==n-1) return 1;
        if(visited[i][j]) return 0;
        if(memo[i][j]!=-1) return memo[i][j];
        int res=0;
        visited[i][j] = true;
        for(int[]dir : dirs) {
            res+=dfs(i+dir[0],j+dir[1],m,n,dirs,visited,memo);
        } 
        visited[i][j] = false;
        return memo[i][j] = res;
    }
}
