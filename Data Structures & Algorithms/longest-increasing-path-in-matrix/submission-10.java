class Solution {
    int dirs[][] = {{-1,0},{1,0},{0,-1},{0,1}};
    int[][] memo;
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        
        int res = 1;
        memo = new int[n][m];
               
        for(int i = 0; i< n; i++){
            for(int j = 0; j< m; j++){
                
                res = Math.max(solve(i,j,matrix),res);
            }
        }
        return res;
    }
    int solve(int r, int c, int[][] matrix){
        if(memo[r][c] != 0) return memo[r][c];
        int res = 1;
        for(int dir[]: dirs ){
            int nr = r + dir[0];
            int nc = c + dir[1];
            if(nr >=0 &&
                nc >= 0 &&
                nr < matrix.length &&
                nc < matrix[0].length &&
                matrix[nr][nc] > matrix[r][c] ){
                res=Math.max( 1+solve(nr, nc, matrix), res);
            }
        }
        return memo[r][c] = res;
    }
}
