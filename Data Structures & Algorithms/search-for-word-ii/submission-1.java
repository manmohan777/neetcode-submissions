class Solution {

    class Node{
        Node[] next = new Node[26];
        boolean end = false;
        String word = "";
    }

    Node root; 
    int[][] dirs ={{0,-1}, {0,1}, {1,0}, {-1,0}};
   
    void add(String word){
        Node node = root;
        for(char c : word.toCharArray()){
            int index = c-'a';
            if(node.next[index] == null){
                node.next[index] = new Node(); 
            }
            node = node.next[index];
        }
        node.end = true;
        node.word = word;
    }

    public List<String> findWords(char[][] board, String[] words) {
        root = new Node();
        for(String word: words){
            add(word);
        }
        List<String> res = new ArrayList();
        int n = board.length;
        int m = board[0].length;
        for(int i = 0; i<n; i++){
            for(int j = 0; j < m; j++){
                dfs(board, root, res, i,j);
            }
        }
        return res;
    }

    void dfs(char[][] board, Node root, List<String> res, int r, int c )
    {
        if( r<0 ||
            c < 0 ||
            r >= board.length ||
            c >= board[0].length ||
            board[r][c] == '#' ||
            root.next[board[r][c]-'a'] == null)
              return;

        char current = board[r][c];
        board[r][c] = '#';
        if(root.next[current-'a'].end){
            res.add(root.next[current-'a'].word);
            root.next[current-'a'].end = false;
        }
        
        for(int dir[] : dirs){
            int nr = dir[0] + r;
            int nc = dir[1] + c;
            dfs(board, root.next[current-'a'], res, nr,nc);
        }
        
        board[r][c] = current;
    }

}
