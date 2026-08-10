class Solution {
    public boolean exist(char[][] board, String word) {
        char[] chars=word.toCharArray();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(dfs(board,i,j,chars,0))
                    return true;
            }
        }
        return false;
    }

    boolean dfs(char[][] board,int row,int col,char[] chars,int i){
        if(i==chars.length)
            return true;
        if(row<0||row>=board.length)
            return false;
        if(col<0||col>=board[0].length)
            return false;
        if(chars[i]!=board[row][col])
            return false;
        boolean res=false;
        char temp=board[row][col];
        board[row][col]='*';
        res=dfs(board,row+1,col,chars,i+1)||
            dfs(board,row-1,col,chars,i+1)||
            dfs(board,row,col+1,chars,i+1)||
            dfs(board,row,col-1,chars,i+1);
        board[row][col]=temp;
        return res;
    }
}
