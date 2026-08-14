class Solution {
    public void solve(char[][] board) {
        int rows = board.length, cols = board[0].length;
        for(int i=0; i<rows; i++){
            dfs(board,i,0);
            dfs(board,i,cols-1);
        }
        for(int j=0; j<cols; j++){
            dfs(board,0,j);
            dfs(board,rows-1, j);
        }
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(board[i][j]=='O')
                    board[i][j] = 'X';
                if(board[i][j]=='Y')
                    board[i][j] = 'O';
            }
        }
    }
    int dirs[][] = {{0,1},{0,-1},{1,0},{-1,0}};
    void dfs(char[][] board, int i, int j){
        if(i<0 || j<0 || i>=board.length|| j>= board[0].length
        || board[i][j]!='O')
            return;
        board[i][j]='Y';
        for(int dir[] : dirs){
            dfs(board,i+dir[0],j+dir[1]);
        }
        
    }
}
