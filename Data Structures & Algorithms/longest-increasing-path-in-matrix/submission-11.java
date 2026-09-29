class Solution {
    int dirs[][] = {{-1,0},{1,0},{0,-1},{0,1}};
    Map<String, Integer> memo;
    public int longestIncreasingPath(int[][] matrix) {
        memo = new HashMap<>();
        int n = matrix.length;
        int m = matrix[0].length;
        int res = 0;
        for(int i = 0; i < n; i++ ){
            for( int j = 0; j < m; j++){
                res=Math.max(dfs(matrix, i, j, -1),res);
            }
        }
        return res;
    }
    int dfs(int[][] matrix, int r, int c, int parent){
        if(r<0 || c < 0 || r >= matrix.length || c >= matrix[0].length) return 0;
        if(matrix[r][c] <= parent) return 0;
        String key = r+" "+c;
        if(memo.containsKey(key)) return memo.get(key);
        int res = 1;
        for(int[] dir: dirs){
            res = Math.max(1 + dfs(matrix, r+dir[0], c + dir[1], matrix[r][c]), res);
        }
        memo.put(key,res);
        return res;
    }

}
