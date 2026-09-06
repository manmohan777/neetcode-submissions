class Solution {
    int dirs[][] = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length; i++){
            for(int j=0;j<board[0].length; j++){
                if(dfs(board,word,i,j,0,new boolean[board.length][board[0].length]))
                    return true;
            }
        }
        return false;
    }
    boolean dfs(char[][] board,String word, int r, int c, int i, boolean[][] visited){
        if(i==word.length())
            return true;
        if(r < 0 || c < 0 || r >= board.length || c >= board[0].length || visited[r][c]) 
            return false;
        if(word.charAt(i) != board[r][c]) 
            return false;
        visited[r][c] = true;
        for(int dir[] : dirs){
            int nr=r+dir[0], nc=c+dir[1];
            if(dfs(board, word, nr, nc, i+1, visited)) return true;
        }
        visited[r][c] = false;
        return false;
    }
}
