class Solution {
    int dirs[][] = {{-1,0},{1,0},{0,-1},{0,1}};
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int res = 0;
        int[][] memo = new int[n][m];
        for(int mem[] : memo){
            Arrays.fill(mem, -1);
        }
        for(int i = 0; i < n; i++ ){
            for( int j = 0; j < m; j++){
                res=Math.max(dfs(matrix, i, j, -1,memo),res);
            }
        }
        return res;
    }

    int dfs(int[][] matrix,int i,int j,int parent,int[][] memo){
        if(i < 0 || j < 0 || i>= matrix.length || j >= matrix[0].length){
            return 0;
        }
        if(matrix[i][j]<=parent){
            return 0;
        }
       if(memo[i][j]!= -1 ) return memo[i][j];
        int res=0;
        
        for(int dir[]: dirs){
            res=Math.max(dfs(matrix,i+dir[0],j+dir[1],matrix[i][j],memo),res);
        }
        return memo[i][j] = 1+res;
    }
}
