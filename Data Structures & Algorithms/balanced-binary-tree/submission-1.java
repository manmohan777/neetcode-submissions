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
        int left = maxHeight(root.left);
        int right = maxHeight(root.right);
        if(Math.abs(left-right)>1) return false;

        return isBalanced(root.left)&& isBalanced(root.right);
    }
    int maxHeight(TreeNode node){
        if(node == null) return 0;
        int left = maxHeight(node.left);
        int right = maxHeight(node.right);
        return 1+ Math.max(left,right);
    }
}
