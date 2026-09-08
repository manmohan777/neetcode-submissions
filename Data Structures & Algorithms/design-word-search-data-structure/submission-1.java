class WordDictionary {
    class Node{
        Node next[] = new Node[26];
        boolean end = false;
    }
    Node root;
    public WordDictionary() {
        root= new Node();
    }

    public void addWord(String word) {
        Node node = root;
        for(int c: word.toCharArray()){
            int index = c-'a';
            if(node.next[index] == null){
                node.next[index] = new Node();
            }
            node = node.next[index];
            
        }
        node.end = true;
    }

    public boolean search(String word) {
       return dfs(word,0,root);
    }

    boolean dfs(String word, int j, Node root){
        Node node = root;
        for(int i = j; i < word.length(); i++){
            char c = word.charAt(i);
            if(c =='.'){
                for(Node child: node.next){
                    if(child!= null && dfs(word, i+1,child)) 
                        return true; 
                }
                return false;
            }else{
                if(node.next[c-'a']==null)
                    return false;
                node = node.next[c-'a'];
            }
        }
        return node.end;
    }
}
