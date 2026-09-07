/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        Map<TreeNode,Integer> map = new HashMap();
        int left = maxHeight(root.left, map);
        int right = maxHeight(root.right, map);
        int diameter = left+right;
        int sub=Math.max(diameterOfBinaryTree(root.left),diameterOfBinaryTree(root.right));
        return Math.max(diameter,sub);
    }
    int maxHeight(TreeNode root, Map<TreeNode, Integer> map){
        if(root == null) return 0;
        if(map.containsKey(root)) return map.get(root);
        int left = maxHeight(root.left, map);
        int right = maxHeight(root.right, map);
        int res = 1+ Math.max(left,right);
        map.put(root, res);
        return res;
    }
}
