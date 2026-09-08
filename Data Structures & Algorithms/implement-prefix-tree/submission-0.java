class PrefixTree {
    class Node{
        Node next[]=new Node[26];
        boolean isWordEnd = false;
        String word="";
    }
    Node root;

    public PrefixTree() {
        root=new Node();
    }

    public void insert(String word) {
        Node node = root;
        for(char c : word.toCharArray()){
            if(node.next[c-'a']!=null){
                node = node.next[c-'a'];
            }else{
                node.next[c-'a'] = new Node();
                node = node.next[c-'a'];
            }
        }
        node.isWordEnd = true;
        node.word = word;
    }

    public boolean search(String word) {
        Node node = root;
        for(int i = 0; i< word.length(); i++){
            int index = word.charAt(i)-'a';
            if(node.next[index] == null){
                return false;
            }
            node = node.next[index];
        }
        
        return node.isWordEnd;
    }

    public boolean startsWith(String prefix) {
        Node node = root;
        for(int i = 0; i< prefix.length(); i++){
            int index = prefix.charAt(i)-'a';
            if(node.next[index] == null){
                return false;
            }
            node = node.next[index];
        }
        return true;
    }
}
