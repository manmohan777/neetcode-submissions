class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer,Set<Character>> row=new HashMap<>();
        Map<Integer,Set<Character>> column=new HashMap<>();
        Map<String,Set<Character>> square=new HashMap<>();
        int n=board.length;
        int m=board[0].length;
        for(int r=0;r<n;r++){
            for(int c=0;c<m; c++){
                if(board[r][c]=='.') continue;
                String sq=r/3+","+c/3;
                if(
                    row.computeIfAbsent(r,k-> new HashSet<Character>()).contains(board[r][c])
                    ||column.computeIfAbsent(c,k-> new HashSet<Character>()).contains(board[r][c])
                    ||square.computeIfAbsent(sq,k-> new HashSet<Character>()).contains(board[r][c])
                ){
                    return false;
                }
                row.computeIfAbsent(r,k-> new HashSet<Character>()).add(board[r][c]);
                column.computeIfAbsent(c,k-> new HashSet<Character>()).add(board[r][c]);
                square.computeIfAbsent(sq,k-> new HashSet<Character>()).add(board[r][c]);
            }
        }
        return true;

    }
}
