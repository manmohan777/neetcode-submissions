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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> res= new ArrayList();
        dfs(root,k,res);
        return res.get(k-1);
    }
    void dfs(TreeNode root, int k, List<Integer> res){
        if(res.size()==k) return;
        if(root == null) return;
        dfs(root.left, k, res);
        res.add(root.val);
        dfs(root.right, k, res);
    }
}
