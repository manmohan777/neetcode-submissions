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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return solve(preorder,inorder,0,inorder.length-1,new int[]{0});
    }
    TreeNode solve(int[] preorder, int[] inorder, int start, int end, int[] index){
        if(start>end) return null;
        int rootVal = preorder[index[0]];
        int i = start;
        while(i<=end){
            if(inorder[i]==rootVal) break;
            i++;
        }
        index[0]++;
        TreeNode root = new TreeNode(rootVal);
        root.left = solve(preorder, inorder, start,i-1,index);
        root.right = solve(preorder, inorder, i+1,end, index);
        return root;

    }
}
