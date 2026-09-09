/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        HashMap<Node,Node> map= new HashMap();
        return dfs(node,map);
    }
   Node dfs(Node root, HashMap<Node,Node> map){
        if(root == null) return null;
        if(map.containsKey(root)) return map.get(root);
        Node cp = new Node(root.val);
        map.put(root,cp);
        for(Node nei: root.neighbors){
            cp.neighbors.add(dfs(nei,map));
        }
        return cp;
   }
}