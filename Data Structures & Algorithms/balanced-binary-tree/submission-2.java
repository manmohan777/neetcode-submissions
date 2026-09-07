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
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        Map<TreeNode,Integer> map = new HashMap<>();
        int left = maxHeight(root.left, map);
        int right = maxHeight(root.right, map);
        if(Math.abs(left-right)>1) return false;

        return isBalanced(root.left)&& isBalanced(root.right);
    }
    int maxHeight(TreeNode node, Map<TreeNode, Integer> map){
        if(node == null) return 0;
        if(map.containsKey(node)) return map.get(node);
        int left = maxHeight(node.left, map);
        int right = maxHeight(node.right, map);
        int res = 1+ Math.max(left,right);
        map.put(node,res);
        return res;
    }
}
